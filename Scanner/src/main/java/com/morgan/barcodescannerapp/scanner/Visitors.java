package com.morgan.barcodescannerapp.scanner;

import android.view.View;

/**
 * Created by Eugene Kamadi on 7/1/2014.
 */
public class Visitors {



        // private variables
       private int visitorid;
          private int autogenno;
        private String compserialno;


        public int getvisitorid() {
            return visitorid;
        }

        public void setvisitorid(int visitorid) {
            this.visitorid = visitorid;
        }

        public int getautogenno() {
            return autogenno;
        }

        public void setAutogenno(int autogenno) {
            this.autogenno = autogenno;
        }

        public String getCompserialno() {
            return compserialno;
        }

        public void setCompserialno(String compserialno) {
            this.compserialno = compserialno;
        }



        // constructor
        public Visitors( int autogenno, String compserialno) {
            //this.id = id;
            this.autogenno = autogenno;
            this.compserialno = compserialno;

        }




    }
