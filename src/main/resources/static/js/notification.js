function updateNotification() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/rest/notification/count",
        dataType: 'json',
        success: function (data) {
            if (data.count > 0) {
                $("#notificationCount").text(data.count);
            }
            setTimeout(updateNotification, 10000);
        },
        error: function () {
            setTimeout(updateNotification, 10000);
        }
    });
}
updateNotification();