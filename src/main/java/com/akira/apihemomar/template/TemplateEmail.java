package com.akira.apihemomar.template;

public class TemplateEmail {

    public static String templateAlteracaoSenha(String conteudo){
         return  "<div style='display: flex; align-items: center;'>" +
                 "<div style='padding: 10px;'><strong>Código :</strong></div>"+
                 "<div style='padding: 10px;background-color: #000; color: #fff; font-size: 14px;'><strong>"+" "+ conteudo +"</strong>"+"</div>"+"</div>";

    }
    public static String templateAlteracaoStatus(String conteudo){
        return  "<div style='display: flex; align-items: center;'>" +
                "<div style='padding: 10px;background-color: #fff; color: #130F7C; font-size: 14px;'><strong>"+" "+ conteudo +"</strong>"+"</div>"+"</div>";
    }

}
