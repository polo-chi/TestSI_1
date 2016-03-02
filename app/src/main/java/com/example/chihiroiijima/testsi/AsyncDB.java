package com.example.chihiroiijima.testsi;

/**
 * Created by Chihiro Iijima on 2016/03/02.
 */

import com.loopj.android.http.*;
import cz.msebera.android.httpclient.*;
import java.util.regex.Pattern;
//import com.ning.http.client.*;
//import com.ning.http.client.AsyncHttpClient;

import java.io.IOException;
import java.util.concurrent.Future;

public class AsyncDB{
    String urlSave = "http://www.gene-design.kit.ac.jp/php/save_brick.php";
    String urlLoad = "http://www.gene-design.kit.ac.jp/php/load_brick.php";
    final RequestParams params;
    String seq = "seq";
    String id = "load_id";
    String passByAsyncDB;
    String[] brickData;

    //コンストラクタ生成
    public AsyncDB() {
        params = new RequestParams(); //リクエストパラメータ
    }

    //DBにデータを追加しパスを得る
    public void setPassByAsyncDB(String brickTitle, String brickDNA, String brickKind, String brickMemo){

        params.put(seq, brickTitle+","+brickDNA+","+brickKind+","+brickMemo); //送るパラメータ

        AsyncHttpClient client = new AsyncHttpClient(); //通信準備

        client.post(urlSave, params, new AsyncHttpResponseHandler() {
             //パラメータを伴い通信開始
            //～通信後の処理～

           // @Override

          /*  public void onSuccess(String response) {
                try {
                    ar = new JSONArray(response); //受け取ったデータを配列にします
                    JSONObject obj1 = ar.getJSONObject(0); //配列内のオブジェクトデータを取得
                    JSONObject obj2 = ar.getJSONObject(1); //配列内のオブジェクトデータを取得
                    System.out.println(obj1.getString("hoge")); // "fuga"
                    System.out.println(obj2.getString("aa"); // "bb"

                    passByAsyncDB = new String();
                    passByAsyncDB = response;

                }catch(Exception e){
                    System.out.println("Error");
                }
            }*/

           /* //@Override
            public void onFailure(){

            }   */

            @Override
            public void onStart() {

            }

            @Override
            public void onFinish() {

            }

            //通信成功時の処理
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String response = new String(responseBody);
                passByAsyncDB = new String();
                passByAsyncDB = response;
                System.out.println("Success   "+passByAsyncDB);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                System.out.println("Error");
            }


        });
    }

    public String getPassByAsyncDB(){
        return passByAsyncDB;
    }

//DBにアクセスし、パスからブリックの情報を得る
    public void setBrickDataByAsyncDB(String pass){

        params.put(id, pass);   //送るパラメータ
        AsyncHttpClient client = new AsyncHttpClient(); //通信準備
        client.post(urlLoad, params, new AsyncHttpResponseHandler() {//パラメータを伴い通信開始

            //通信成功時の処理
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String response = new String(responseBody);
                brickData = new String[4];
                Pattern p = Pattern.compile("[,]");
                brickData = p.split(response);
                System.out.println("Success   "+brickData[0]+brickData[1]+brickData[2]+brickData[3]);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                System.out.println("Error");
            }


            //～通信後の処理～


          /*  public void onSuccess(String response) {//responseはブリックのタイトル,塩基配列,DNAの種類,メモで構成される
                try {
                    ar = new JSONArray(response); //受け取ったデータを配列にします
                    JSONObject obj1 = ar.getJSONObject(0); //配列内のオブジェクトデータを取得
                    JSONObject obj2 = ar.getJSONObject(1); //配列内のオブジェクトデータを取得
                    System.out.println(obj1.getString("hoge")); // "fuga"
                    System.out.println(obj2.getString("aa"); // "bb"


                }catch(Exception e){
                    System.out.println("Error");
                }
            }*/

           /* //@Override
            public void onFailure(){

            }   */

            @Override
            public void onStart() {

            }

            @Override
            public void onFinish() {

            }


        });
    }
}
