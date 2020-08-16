package kg.itacademy.gsg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/website")
public class WebsiteController {

    @GetMapping(value = "/404")
    public String error() {
        return "website/404";
    }
    @GetMapping(value = "/index")
    public String index() {
        return "website/main/index";
    }
    @GetMapping(value = "/home")
    public String home() {
        return "website/main/home";
    }
    @GetMapping(value = "/about")
    public String about(Model model) {
        model.addAttribute("about", true);
        return "website/aboutUs/about";
    }
    @GetMapping(value = "/service")
    public String service() {
        return "website/services/services";
    }
    @GetMapping(value = "/service/marketing")
    public String marketing() {
        return "website/services/marketing";
    }
    @GetMapping(value = "/service/marketing/strategy")
    public String marketingStrategy() {
        return "website/services/marketing_strategy";
    }
    @GetMapping(value = "/service/marketing/businessplan")
    public String marketingBusinessplan() {
        return "website/services/marketing_businessplan";
    }
    @GetMapping(value = "/service/marketing/RD")
    public String marketingRD() {
        return "website/services/marketing_RD";
    }
    @GetMapping(value = "/service/consulting")
    public String consulting() {
        return "website/services/consulting";
    }
    @GetMapping(value = "/service/sales")
    public String sales() {
        return "website/services/sales";
    }
    @GetMapping(value = "/service/eventOrganization")
    public String eventOrganization() {
        return "website/services/eventorganization";
    }
    @GetMapping(value = "/service/production")
    public String production() {
        return "website/services/production";
    }
    @GetMapping(value = "/service/production/photo")
    public String productionPhoto() {
        return "website/services/production_photo";
    }
    @GetMapping(value = "/service/production/photo/subject")
    public String photoSubject() {
        return "website/services/production_photo_photoSubject";
    }
    @GetMapping(value = "/service/production/photo/interier")
    public String photoInterier() {
        return "website/services/production_photo_photoInterier";
    }
    @GetMapping(value = "/service/production/photo/image")
    public String photoImage() {
        return "website/services/production_photo_photoImage";
    }
    @GetMapping(value = "/service/production/photo/reportage")
    public String photoReportage() {
        return "website/services/production_photo_photoReportage";
    }
    @GetMapping(value = "/service/production/video")
    public String productionVideo() {
        return "website/services/production_video";
    }
    @GetMapping(value = "/service/production/video/advertisement")
    public String videoAdvertisement() {
        return "website/services/production_video_videoAdvertisement";
    }
    @GetMapping(value = "/service/production/video/event")
    public String videoEvent() {
        return "website/services/production_video_videoEvent";
    }
    @GetMapping(value = "/service/production/video/reportage")
    public String videoReportage() {
        return "website/services/production_video_videoReportage";
    }
    @GetMapping(value = "/service/production/video/promo")
    public String videoPromo() {
        return "website/services/production_video_videoPromo";
    }
    @GetMapping(value = "/service/production/youtube")
    public String youtube() {
        return "website/services/production_youtube";
    }
    @GetMapping(value = "/service/production/tiktok")
    public String tiktok() {
        return "website/services/production_tiktok";
    }
    @GetMapping(value = "/service/branding")
    public String branding() {
        return "website/services/branding";
    }
    @GetMapping(value = "/service/branding/analysis")
    public String brandingAnalysis() {
        return "website/services/branding_analysis";
    }
    @GetMapping(value = "/service/branding/style")
    public String brandingStyle() {
        return "website/services/branding_style";
    }
    @GetMapping(value = "/service/branding/seo")
    public String brandingSeo() {
        return "website/services/branding_seo";
    }
    @GetMapping(value = "/service/branding/smm")
    public String brandingSmm() {
        return "website/services/branding_smm";
    }
    @GetMapping(value = "/service/branding/bot")
    public String brandingBot() {
        return "website/services/branding_bot";
    }
    @GetMapping(value = "/service/branding/event")
    public String brandingEvent() {
        return "website/services/branding_event";
    }
    @GetMapping(value = "/service/it/website")
    public String website() {
        return "website/services/it_website";
    }
    @GetMapping(value = "/service/it/website/eshop")
    public String websiteEshop() {
        return "website/services/it_website_eshop";
    }
    @GetMapping(value = "/service/it/website/corporate")
    public String websiteCorporate() {
        return "website/services/it_website_corporate";
    }
    @GetMapping(value = "/service/it/landingpage")
    public String landingpage() {
        return "website/services/it_landingpage";
    }
    @GetMapping(value = "/service/it/advlist")
    public String advlist() {
        return "website/services/it_advlist";
    }
    @GetMapping(value = "/service/adv")
    public String adv() {
        return "website/services/adv";
    }
    @GetMapping(value = "/service/adv/complex")
    public String advComplex() {
        return "website/services/adv_complex";
    }
    @GetMapping(value = "/service/adv/context")
    public String advContext() {
        return "website/services/adv_context";
    }
    @GetMapping(value = "/service/adv/smm")
    public String advSmm() {
        return "website/services/adv_smm";
    }

    @GetMapping(value = "/service/adv/tv")
    public String advTv() {
        return "website/services/adv_tv";
    }

    @GetMapping(value = "/service/design")
    public String design() {
        return "website/services/design";
    }

    @GetMapping(value = "/service/smm")
    public String smm() {
        return "website/services/smm";
    }

    @GetMapping(value = "/service/smm/facebook")
    public String smmFacebook() {
        return "website/services/smm_facebook";
    }
    @GetMapping(value = "/service/smm/telegram")
    public String smmTelegram() {
        return "website/services/smm_telegram";
    }
    @GetMapping(value = "/service/smm/instagram")
    public String smmInstagram() {
        return "website/services/smm_instagram";
    }

    @GetMapping(value = "/clients")
    public String clientsPortfolio() {
        return "website/clients/clients_portfolio";
    }

    @GetMapping(value = "/contacts")
    public String context() {
        return "website/contacts/contacts";
    }

    @GetMapping(value = "/contact")
    public String contact() {
        return "website/contact";
    }
}
