@import injectionValiable
env.injectionOne = {cassette, record, labelList, imageTable ->
 myInjectionOne(cassette, record, labelList, imageTable);
};
if(!env.multiLayout) {
 doProduce(1, env.imageTable); // ページ数 1
}

//独自の刺し込み処理
def myInjectionOne(cassette, record, labelList, imageTable) {

  def additionalLabelList = ['住所1','住所2'];

  selectedAddress = record['選択住所'];

  switch(selectedAddress){
    case '永福（アルク）':
    record['住所1'] = '〒168-8611 東京都杉並区永福2-54-12';
    record['住所2'] = '';
    break;
    case "市ヶ谷（アルク）":
    record['住所1'] = '〒102-0073 東京都千代田区九段北4-2-6';
    record['住所2'] = '';
    break;
    case "市ヶ谷2階（アルク）":
    record['住所1'] = '〒102-0073 東京都千代田区九段北4-2-6';
    record['住所2'] = '';
    break;
    case "市ヶ谷8階（アルク）":
    record['住所1'] = '〒102-0073 東京都千代田区九段北4-2-6';
    record['住所2'] = '';
    break;
    case "大阪（アルク）" :
    record['住所1'] = '〒541-0047 大阪府大阪市中央区淡路町3-6-3';
    record['住所2'] = '';
    break;
    case "大郷ビル5階（アルク）":
    record['住所1'] = '〒102-0076 東京都千代田区五番町1-10';
    record['住所2'] = '';
    break;
    case "福岡（アルク）":
    record['住所1'] = '〒810-0004 福岡県福岡市中央区渡辺通4-10-10';
    record['住所2'] = '';
    break;
    case "名古屋（アルク）":
    record['住所1'] = '〒461-0005 愛知県名古屋市東区東桜1-10-35';
    record['住所2'] = '';
    break;
    case "":
    record['住所1'] = '';
    record['住所2'] = '';
    break;
  }


  //基本関数
  labelList.each {
    injectionOneParts(cassette, it , record, imageTable);
  }

  additionalLabelList.each {
    injectionOneParts(cassette, it , record, imageTable);
  }

  //表面の判定
  def omote = getPartsByLabel('肩書き1', 1, cassette) ;
  //表面の処理ここから
  if(omote != null){
    //表面のパーツ操作スクリプト
    //関連パーツ取得

  }
}
