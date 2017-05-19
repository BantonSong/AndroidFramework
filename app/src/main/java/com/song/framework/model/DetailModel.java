package com.song.framework.model;

import java.util.List;

/**
 * Created by songyawei on 2017/4/13.
 */
public class DetailModel {

    /**
     * name : 好大喜功
     * pronounce : hào  dà  xǐ  gōng
     * content : 指不管条件是否许可，一心想做大事立大功。多用以形容浮夸的作风。
     * comefrom : 宋·罗泌《路史·前纪》卷四：“昔者汉之武帝，好大而喜功。”《新唐书·太宗纪赞》：“至其牵于多爱，复立浮屠，好大喜功，勤兵于远，此中材庸主之所常为。”
     * antonym : ["脚踏实地","老成持重","稳扎稳打"]
     * thesaurus : ["沽名钓誉","好高骛远"]
     * example : 1. 然而，总体而言他不是好大喜功的类型。
     2. 草率的银行，好大喜功的官员，贪婪的外国投资者；很多方面都被认作是中国经济过热的罪魁祸首。
     3. 好大喜功的戈夫先生说他要把“钟形曲线向右移”，即对所有学生提高要求。
     4. 一些领导干部存在着不良作风,具体表现为:一是急功近利,
     */

    private String name;
    private String pronounce;
    private String content;
    private String comefrom;
    private String example;
    private List<String> antonym;
    private List<String> thesaurus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComefrom() {
        return comefrom;
    }

    public void setComefrom(String comefrom) {
        this.comefrom = comefrom;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public List<String> getAntonym() {
        return antonym;
    }

    public void setAntonym(List<String> antonym) {
        this.antonym = antonym;
    }

    public List<String> getThesaurus() {
        return thesaurus;
    }

    public void setThesaurus(List<String> thesaurus) {
        this.thesaurus = thesaurus;
    }
}
