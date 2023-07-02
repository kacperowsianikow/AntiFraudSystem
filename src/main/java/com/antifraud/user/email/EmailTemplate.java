package com.antifraud.user.email;

public class EmailTemplate {

    public static String createEmail(String name, String link) {
        return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"font-family:arial, 'helvetica neue', helvetica, sans-serif\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
                "<meta name=\"x-apple-disable-message-reformatting\">\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "<meta content=\"telephone=no\" name=\"format-detection\">\n" +
                "<title>New message</title><!--[if (mso 16)]>\n" +
                "<style type=\"text/css\">\n" +
                "a {text-decoration: none;}\n" +
                "</style>\n" +
                "<![endif]--><!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--><!--[if gte mso 9]>\n" +
                "<xml>\n" +
                "<o:OfficeDocumentSettings>\n" +
                "<o:AllowPNG></o:AllowPNG>\n" +
                "<o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "</o:OfficeDocumentSettings>\n" +
                "</xml>\n" +
                "<![endif]--><!--[if !mso]><!-- -->\n" +
                "<link href=\"https://fonts.googleapis.com/css2?family=Imprima&display=swap\" rel=\"stylesheet\"><!--<![endif]-->\n" +
                "<style type=\"text/css\">\n" +
                "#outlook a {\n" +
                "padding:0;\n" +
                "}\n" +
                ".es-button {\n" +
                "mso-style-priority:100!important;\n" +
                "text-decoration:none!important;\n" +
                "}\n" +
                "a[x-apple-data-detectors] {\n" +
                "color:inherit!important;\n" +
                "text-decoration:none!important;\n" +
                "font-size:inherit!important;\n" +
                "font-family:inherit!important;\n" +
                "font-weight:inherit!important;\n" +
                "line-height:inherit!important;\n" +
                "}\n" +
                ".es-desk-hidden {\n" +
                "display:none;\n" +
                "float:left;\n" +
                "overflow:hidden;\n" +
                "width:0;\n" +
                "max-height:0;\n" +
                "line-height:0;\n" +
                "mso-hide:all;\n" +
                "}\n" +
                "[data-ogsb] .es-button {\n" +
                "border-width:0!important;\n" +
                "padding:15px 20px 15px 20px!important;\n" +
                "}\n" +
                "@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120% } h1 { font-size:30px!important; text-align:left } h2 { font-size:24px!important; text-align:left } h3 { font-size:20px!important; text-align:left } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:30px!important; text-align:left } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:24px!important; text-align:left } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important; text-align:left } .es-menu td a { font-size:14px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:14px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:14px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:14px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:block!important } a.es-button, button.es-button { font-size:18px!important; display:block!important; border-right-width:0px!important; border-left-width:0px!important; border-top-width:15px!important; border-bottom-width:15px!important } .es-adaptive table, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; max-height:inherit!important } }\n" +
                "</style>\n" +
                "</head>\n" +
                "<body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
                "<div class=\"es-wrapper-color\" style=\"background-color:#FFFFFF\"><!--[if gte mso 9]>\n" +
                "<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                "<v:fill type=\"tile\" color=\"#ffffff\"></v:fill>\n" +
                "</v:background>\n" +
                "<![endif]-->\n" +
                "<table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:#FFFFFF\">\n" +
                "<tr>\n" +
                "<td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                "<table class=\"es-footer\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
                "<tr>\n" +
                "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "<table class=\"es-footer-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#bcb8b1\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
                "<tr>\n" +
                "<td align=\"left\" style=\"Margin:0;padding-top:20px;padding-bottom:20px;padding-left:40px;padding-right:40px\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:520px\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td style=\"padding:0;Margin:0;font-size:0px\" align=\"center\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#2D3142;font-size:14px\"><img src=\"https://gexayc.stripocdn.email/content/guids/CABINET_055ba03e85e991c70304fecd78a2dceaf6b3f0bc1b0eb49336463d3599679494/images/vector.png\" alt=\"Logo\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" title=\"Logo\" height=\"60\"></a></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                "<tr>\n" +
                "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "<table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#EFEFEF;border-radius:20px 20px 0 0;width:600px\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#efefef\" align=\"center\">\n" +
                "<tr>\n" +
                "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:40px;padding-left:40px;padding-right:40px\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:520px\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td class=\"es-m-txt-c\" style=\"padding:0;Margin:0;font-size:0px\" align=\"left\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#2D3142;font-size:18px\"><img src=\"https://gexayc.stripocdn.email/content/guids/CABINET_ee77850a5a9f3068d9355050e69c76d26d58c3ea2927fa145f0d7a894e624758/images/group_4076323.png\" alt=\"Confirm email\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;border-radius:100px\" title=\"Confirm email\" width=\"100\"></a></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:40px;padding-right:40px\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:520px\">\n" +
                "<table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;background-color:#fafafa;border-radius:10px\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fafafa\" role=\"presentation\">\n" +
                "<tr>\n" +
                "<td align=\"left\" style=\"padding:20px;Margin:0\"><h3 style=\"Margin:0;line-height:34px;mso-line-height-rule:exactly;font-family:Imprima, Arial, sans-serif;font-size:28px;font-style:normal;font-weight:bold;color:#2D3142\">Welcome, " + name + "</h3><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:Imprima, Arial, sans-serif;line-height:27px;color:#2D3142;font-size:18px\"><br></p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:Imprima, Arial, sans-serif;line-height:27px;color:#2D3142;font-size:18px\">You're receiving this message because you recently signed up for an account.<br><br>Confirm your email address by clicking the button below.</p></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                "<tr>\n" +
                "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "<table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#efefef\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#EFEFEF;width:600px\">\n" +
                "<tr>\n" +
                "<td align=\"left\" style=\"Margin:0;padding-top:30px;padding-bottom:40px;padding-left:40px;padding-right:40px\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:520px\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td align=\"center\" style=\"padding:0;Margin:0\"><!--[if mso]><a href=\"" + link + "\" target=\"_blank\" hidden>\n" +
                "<v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" esdevVmlButton href=\"" + link + "\"\n" +
                "style=\"height:56px; v-text-anchor:middle; width:520px\" arcsize=\"50%\" stroke=\"f\" fillcolor=\"#7630f3\">\n" +
                "<w:anchorlock></w:anchorlock>\n" +
                "<center style='color:#ffffff; font-family:Imprima, Arial, sans-serif; font-size:22px; font-weight:700; line-height:22px; mso-text-raise:1px'>Confirm email</center>\n" +
                "</v:roundrect></a>\n" +
                "<![endif]--><!--[if !mso]><!-- --><span class=\"msohide es-button-border\" style=\"border-style:solid;border-color:#2CB543;background:#7630f3;border-width:0px;display:block;border-radius:30px;width:auto;mso-hide:all\"><a href=\"" + link + "\" class=\"es-button msohide\" target=\"_blank\" style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;color:#FFFFFF;font-size:22px;border-style:solid;border-color:#7630f3;border-width:15px 20px 15px 20px;display:block;background:#7630f3;border-radius:30px;font-family:Imprima, Arial, sans-serif;font-weight:bold;font-style:normal;line-height:26px;width:auto;text-align:center;mso-hide:all;border-left-width:5px;border-right-width:5px\">Confirm email</a></span><!--<![endif]--></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td align=\"left\" style=\"padding:0;Margin:0;padding-left:40px;padding-right:40px\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:520px\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:Imprima, Arial, sans-serif;line-height:27px;color:#2D3142;font-size:18px\">Thanks,<br><br>Company</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"padding:0;Margin:0;padding-bottom:20px;padding-top:40px;font-size:0\" align=\"center\">\n" +
                "<table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td style=\"padding:0;Margin:0;border-bottom:1px solid #666666;background:unset;height:1px;width:100%;margin:0px\"></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                "<tr>\n" +
                "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "<table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#EFEFEF;border-radius:0 0 20px 20px;width:600px\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#efefef\" align=\"center\">\n" +
                "<tr>\n" +
                "<td class=\"esdev-adapt-off\" align=\"left\" style=\"Margin:0;padding-top:20px;padding-bottom:20px;padding-left:40px;padding-right:40px\">\n" +
                "<table class=\"esdev-mso-table\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;width:520px\">\n" +
                "<tr>\n" +
                "<td class=\"esdev-mso-td\" valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                "<table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "<tr>\n" +
                "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:47px\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td class=\"es-m-txt-l\" style=\"padding:0;Margin:0;font-size:0px\" align=\"center\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#2D3142;font-size:18px\"><img src=\"https://gexayc.stripocdn.email/content/guids/CABINET_ee77850a5a9f3068d9355050e69c76d26d58c3ea2927fa145f0d7a894e624758/images/group_4076325.png\" alt=\"Demo\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" title=\"Demo\" width=\"47\"></a></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "<td style=\"padding:0;Margin:0;width:20px\"></td>\n" +
                "<td class=\"esdev-mso-td\" valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                "<table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "<tr>\n" +
                "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:453px\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:Imprima, Arial, sans-serif;line-height:24px;color:#2D3142;font-size:16px\">This link expire in 15 minutes<br></p></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table class=\"es-footer\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
                "<tr>\n" +
                "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "<table class=\"es-footer-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#bcb8b1\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
                "<tr>\n" +
                "<td align=\"left\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-bottom:30px;padding-top:40px\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td align=\"left\" style=\"padding:0;Margin:0;width:560px\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td class=\"es-m-txt-c\" style=\"padding:0;Margin:0;padding-bottom:20px;font-size:0px\" align=\"center\"><img src=\"https://gexayc.stripocdn.email/content/guids/CABINET_055ba03e85e991c70304fecd78a2dceaf6b3f0bc1b0eb49336463d3599679494/images/vector.png\" alt=\"Logo\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;font-size:12px\" title=\"Logo\" height=\"60\"></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"es-m-txt-c\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:20px;font-size:0\" align=\"center\">\n" +
                "<table class=\"es-table-not-adapt es-social\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:5px\"><img src=\"https://gexayc.stripocdn.email/content/assets/img/social-icons/logo-black/twitter-logo-black.png\" alt=\"Tw\" title=\"Twitter\" height=\"24\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\n" +
                "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:5px\"><img src=\"https://gexayc.stripocdn.email/content/assets/img/social-icons/logo-black/facebook-logo-black.png\" alt=\"Fb\" title=\"Facebook\" height=\"24\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\n" +
                "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0\"><img src=\"https://gexayc.stripocdn.email/content/assets/img/social-icons/logo-black/linkedin-logo-black.png\" alt=\"In\" title=\"Linkedin\" height=\"24\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:Imprima, Arial, sans-serif;line-height:20px;color:#2D3142;font-size:13px\"><a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#2D3142;font-size:14px\" href=\"\"></a><a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#2D3142;font-size:14px\" href=\"\">Privacy Policy</a><a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#2D3142;font-size:13px\" href=\"\"></a> • <a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#2D3142;font-size:14px\" href=\"\">Unsubscribe</a></p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td align=\"center\" style=\"padding:0;Margin:0;padding-top:20px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:Imprima, Arial, sans-serif;line-height:21px;color:#2D3142;font-size:14px\"><a target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#2D3142;font-size:14px\"></a>Copyright © 2023&nbsp;Company<a target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#2D3142;font-size:14px\"></a></p></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table class=\"es-footer\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
                "<tr>\n" +
                "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "<table class=\"es-footer-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
                "<tr>\n" +
                "<td align=\"left\" style=\"padding:20px;Margin:0\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td align=\"left\" style=\"padding:0;Margin:0;width:560px\">\n" +
                "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "<tr>\n" +
                "<td class=\"es-infoblock made_with\" style=\"padding:0;Margin:0;line-height:120%;font-size:0;color:#CCCCCC\" align=\"center\"><a target=\"_blank\" href=\"https://viewstripo.email/?utm_source=templates&utm_medium=email&utm_campaign=fashion_8&utm_content=hot_prices\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#CCCCCC;font-size:12px\"><img src=\"https://gexayc.stripocdn.email/content/guids/CABINET_09023af45624943febfa123c229a060b/images/7911561025989373.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"125\"></a></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
    }

}
