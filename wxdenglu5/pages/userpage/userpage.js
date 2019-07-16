var util = require('../../utils/util.js');

Page({

 
  data: {
    hello: "登陆成功！这是用户界面",

    parkfee: 50000,  //停车费用
    parktime: 10000,  //停车时长

    time: 0,
    initTime: '',
    carid: '',
    carnum: ''


  },

  onLoad: function (options) {
    //监听页面加载，从后端获取数据
    var that = this;
    /*
    var initTime = '';
    var carid = '';
    var carnum = '';
    */
    console.log("options.stime:"+options.stime);
    that.setData({
      carid: options.carid,
      carnum: options.carnum,
      initTime: options.stime
    })

    //获取当前时间
    var TIME = util.formatTime(new Date());
    that.setData({
      time: TIME
    });
    
    //计算时间差
    var start_date = new Date(this.data.initTime.replace(/-/g, "/"));
    console.log("入场时间："+start_date);
    var end_date = new Date(this.data.time.replace(/-/g, "/"));
    console.log("出场时间："+end_date);
    var days = end_date.getTime() - start_date.getTime();
    console.log("相差毫秒数："+days);

    //停车时长向上取整，故+1
    var parkhours = parseInt(days / (1000 * 60 * 60)) + 1; 
    console.log("停车时长："+parkhours);
    var fee = 5 * parkhours;
    that.setData({
      parktime: parkhours
    });
    that.setData({
      parkfee: fee
    })

  },

  //结算按钮
  payfee: function() {
    var that = this;
    //点击后出现弹窗
    wx.showModal({
      title: '提示信息',
      content: '确定支付停车费用？',
      showCancel: true,
      cancelText: "否",
      confirmText: "是",
      success: function(res) {
        if(res.cancel) {
          //点击取消，默认隐藏弹窗
        }
        else {
          //将车费和出场时间传向后端        
          wx.request({
            url: 'http://localhost:8080/Parking/loginsert?logid='+that.data.carid+'&carNum='+that.data.carnum+'&startTime='+that.data.initTime+'&endTime='+that.data.time+'&duraTime='+that.data.parktime+'&consum='+that.data.parkfee,
            method: "GET",
            header: {
              'content-type': 'application/json'
            },
            success: function(res) {
              console.log(res.data);
            }
          })

          //返回登录界面
          wx.showToast({
            title: '支付成功',
            icon: 'success',
            duration: 2000,
            success: function() {
              setTimeout(function() {
                wx.redirectTo({
                  url: '/pages/index/index',
                })
              },2000)
            }
          })
          
        }
      },
      fail: function(res) { },
      complete: function(res) { },
    })
  }
})