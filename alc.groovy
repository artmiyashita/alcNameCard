@import injectionValiable
env.injectionOne = {cassette, record, labelList, imageTable ->
 myInjectionOne(cassette, record, labelList, imageTable);
};
if(!env.multiLayout) {
 doProduce(2, env.imageTable); // ページ数 1
}
//段落自動取詰(上基準)メソッド
def linespan = 0;//mm
def lineheight = 0;//mm
def positionY = 0;//mm
def positionX = 0;//mm
def paragraphBuilder2(recordList,partsList,positionY,linespan,lineheight){
  x = recordList.size();
  for(i=0; i<x; i++){
    partsList[i].transform.translateY = positionY + linespan;
    if(recordList[i]==''){
      partsList[i].setDisplay("none");
      linespan += 0;
    }else{
      linespan += lineheight;
    }
  }
}

//独自の刺し込み処理
def myInjectionOne(cassette, record, labelList, imageTable) {

  def additionalLabelList = ["住所1","住所2","Address1","Address2","Address3","URL","電話英1","ファックス英1"];

  class1 = record["肩書き1"];
  class2 = record["肩書き2"];
  class3 = record["肩書き3"];
  class4 = record["肩書き4"];
  class5 = record["肩書き5"];
  classEn1 = record["肩書き英1"];
  classEn2 = record["肩書き英2"];
  classEn3 = record["肩書き英3"];
  classEn4 = record["肩書き英4"];
  classEn5 = record["肩書き英5"];
  selectedAddress = record["選択住所"];

  switch(selectedAddress){
    case "永福（アルク）":
    record["住所1"] = "〒168-8611 東京都杉並区永福2-54-12";
    record["住所2"] = "市ヶ谷ビル5F" ;
    record["Address1"] = "2-54-12 Eifuku, Suginami-ku,";
    record["Address2"] = "Tokyo 168-8611, Japan";
    record["Address3"] = "";
    break;
    case "市ヶ谷（アルク）":
    record["住所1"] = "〒102-0073 東京都千代田区九段北4-2-6";
    record["住所2"] = "市ヶ谷ビル2F";
    record["Address1"] = "5th Floor, Ichigaya Bldg., 4-2-6 Kudankita,";
    record["Address2"] = "Chiyoda-ku, Tokyo 102-0073, Japan";
    record["Address3"] = "";
    break;
    case "市ヶ谷2階（アルク）":
    record["住所1"] = "〒102-0073 東京都千代田区九段北4-2-6";
    record["住所2"] = "市ヶ谷ビル2F";
    record["Address1"] = "2nd Floor, Ichigaya Bldg., 4-2-6 Kudankita,";
    record["Address2"] = "Chiyoda-ku, Tokyo 102-0073, Japan";
    record["Address3"] = "";
    break;
    case "市ヶ谷8階（アルク）":
    record["住所1"] = "〒102-0073 東京都千代田区九段北4-2-6";
    record["住所2"] = "市ヶ谷ビル8F";
    record["Address1"] = "8th Floor, Ichigaya Bldg., 4-2-6 Kudankita,";
    record["Address2"] = "Chiyoda-ku, Tokyo 102-0073, Japan";
    record["Address3"] = "";
    break;
    case "大阪（アルク）" :
    record["住所1"] = "〒541-0047 大阪府大阪市中央区淡路町3-6-3";
    record["住所2"] = "御堂筋MTRビル12F";
    record["Address1"] = "12th Floor, Midosuji MTR Bldg., 3-6-3 Awajimachi,";
    record["Address2"] = "Chuo-ku, Osaka 541-0047, Japan";
    record["Address3"] = "";
    break;
    case "大郷ビル5階（アルク）":
    record["住所1"] = "〒102-0076 東京都千代田区五番町1-10";
    record["住所2"] = "市ヶ谷大郷ビル5F";
    record["Address1"] = "5th Floor, Ichigaya Daigo Bldg.,";
    record["Address2"] = "1-10 Gobancho, Chiyoda-ku, Tokyo";
    record["Address3"] = "102-0076, Japan";
    break;
    case "福岡（アルク）":
    record["住所1"] = "〒810-0004 福岡県福岡市中央区渡辺通4-10-10";
    record["住所2"] = "紙与天神ビル3F";
    record["Address1"] = "3rd Floor, Kamiyo Tenjin Bldg., 4-10-10 Watanabedori,";
    record["Address2"] = "Chuo-ku, Fukuoka 810-0004, Japan";
    record["Address3"] = "";
    break;
    case "名古屋（アルク）":
    record["住所1"] = "〒461-0005 愛知県名古屋市東区東桜1-10-35";
    record["住所2"] = "セントラル野田ビル4F";
    record["Address1"] = "4th Floor, Central Noda Bldg., 1-10-35 Higashisakura,";
    record["Address2"] = "Higashi-ku, Nagoya 461-0005, Japan";
    record["Address3"] = "";
    break;
    case "":
    record["住所1"] = "";
    record["住所2"] = "";
    record["Address1"] = "";
    record["Address2"] = "";
    record["Address3"] = "";
    break;
  }

  jusho1 = record["住所1"];
  jusho2 = record["住所2"];
  adr1 = record["Address1"];
  adr2 = record["Address2"];
  adr3 = record["Address3"];
  email = record["Email"];
  tel1 = record["電話1"];
  fax1 = record["ファックス1"];
  mobile = record["携帯"];
  url = "www.test.com";
  free = record["フリースペース"];

  if(tel1){
    telEn1 = "+81-" + tel1.substring(1,tel1.size());
  }else{
    telEn1 = "";
  }

  if(fax1){
    faxEn1 = "+81-" + fax1.substring(1,fax1.size());
  }else{
    faxEn1 = "";
  }

  record["電話英1"] = telEn1;
  record["ファックス英1"] = faxEn1;

  //基本関数
  labelList.each {
    injectionOneParts(cassette, it , record, imageTable);
  }

  additionalLabelList.each {
    injectionOneParts(cassette, it , record, imageTable);
  }

  //表面の判定
  def omote = getPartsByLabel("肩書き1", 1, cassette);
  //表面の処理ここから
  if(omote != null){
    //表面のパーツ操作スクリプト
    //関連パーツ取得
    pSei = getPartsByLabel("姓", 1, cassette);
    pMei = getPartsByLabel("名", 1, cassette);
    pClass1 = getPartsByLabel("肩書き1", 1, cassette);
    pClass2 = getPartsByLabel("肩書き2", 1, cassette);
    pClass3 = getPartsByLabel("肩書き3", 1, cassette);
    pClass4 = getPartsByLabel("肩書き4", 1, cassette);
    pClass5 = getPartsByLabel("肩書き5", 1, cassette);
    pJusho1 = getPartsByLabel("住所1", 1, cassette);
    pJusho2 = getPartsByLabel("住所2", 1, cassette);
    pEmail = getPartsByLabel("Email", 1, cassette);
    pTel1 = getPartsByLabel("電話1", 1, cassette);
    pFax1 = getPartsByLabel("ファックス1", 1, cassette);
    pMobile = getPartsByLabel("携帯", 1, cassette);
    pUrl = getPartsByLabel("URL", 1, cassette);
    pFree = getPartsByLabel("フリースペース", 1, cassette);

    recordList = [class1,class2,class3,class4,class5];
    partsList = [pClass1,pClass2,pClass3,pClass4,pClass5];
    positionY = 20;
    linespan = 3;
    lineheight = 3;
    paragraphBuilder2(recordList,partsList,positionY,linespan,lineheight);

    recordList = [jusho1,jusho2,email,tel1,fax1,mobile,url,free];
    partsList = [pJusho1,pJusho2,pEmail,pTel1,pFax1,pMobile,pUrl,pFree];
    positionY = 40;
    linespan = 3;
    lineheight = 3;
    paragraphBuilder2(recordList,partsList,positionY,linespan,lineheight);

    pMei.transform.translateX = pSei.transform.translateX + pSei.boundBox.width + 1;
    pMei.transform.translateY = pSei.transform.translateY;

  }else{
    pFirstName = getPartsByLabel("FirstName", 1, cassette);
    pFamilyName = getPartsByLabel("FamilyName", 1, cassette);
    pClassEn1 = getPartsByLabel("肩書き英1", 1, cassette);
    pClassEn2 = getPartsByLabel("肩書き英2", 1, cassette);
    pClassEn3 = getPartsByLabel("肩書き英3", 1, cassette);
    pClassEn4 = getPartsByLabel("肩書き英4", 1, cassette);
    pClassEn5 = getPartsByLabel("肩書き英5", 1, cassette);
    pAdr1 = getPartsByLabel("Address1", 1, cassette);
    pAdr2 = getPartsByLabel("Address2", 1, cassette);
    pAdr3 = getPartsByLabel("Address3", 1, cassette);
    pEmail = getPartsByLabel("Email", 1, cassette);
    pTelEn1 = getPartsByLabel("電話英1", 1, cassette);
    pFaxEn1 = getPartsByLabel("ファックス英1", 1, cassette);
    pMobile = getPartsByLabel("携帯", 1, cassette);
    pUrl = getPartsByLabel("URL", 1, cassette);

    recordList = [classEn1,classEn2,classEn3,classEn4,classEn5];
    partsList = [pClassEn1,pClassEn2,pClassEn3,pClassEn4,pClassEn5];
    positionY = 20;
    linespan = 3;
    lineheight = 3;
    paragraphBuilder2(recordList,partsList,positionY,linespan,lineheight);

    recordList = [adr1,adr2,adr3,email,telEn1,faxEn1,mobile,url];
    partsList = [pAdr1,pAdr2,pAdr3,pEmail,pTelEn1,pFaxEn1,pMobile,pUrl];
    positionY = 40;
    linespan = 3;
    lineheight = 3;
    paragraphBuilder2(recordList,partsList,positionY,linespan,lineheight);
  }
}
