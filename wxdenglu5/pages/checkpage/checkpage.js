// pages/checkpage/checkpage.js
Page({

  
  data: {
    Carid: '',
    Carnumber: '',
    Starttime: '',
    Endtime: '',
    Duratime: '',
    Consume: ''
  },

  onLoad:function(options){
    var that=this;
    console.log(options);
    that.setData({
      Carid:options.carid,
      
      Starttime:options.starttime,
      Endtime:options.endtime,
      Duratime:options.duratime,
      Consume:options.consume,
      Carnumber: options.carnumber

    })
  }

})