// pages/adminpage/adminpage.js
Page({

  data: {
     Carid : '',
     Carnumber : '',
     Starttime : '',
     Endtime : '',
     Duratime : '',
     Consume : ''
  },
  

  formsubmit3: function(e) {

   var that = this;
   var signal = false;
   var vcarnumber = e.detail.value.carnumber;

    
    //车牌传到后端
    wx.request({
      url: 'http://localhost:8080/Parking/logselect?carnum=' + vcarnumber,
      header: {
        'content-type': 'application/json'
      },
      method: "GET",
    
      success: function(res) {
        console.log(res.data);
        let data = res.data;
        let carid = data.logid;
        let carnumber = data.carNum;
        let startime = data.startTime;
        let endtime = data.endTime;
        let duratime = data.duraTime;
        let consum = data.consum;
        console.log(startime);
        
        that.setData({
          Carid:carid,
          Carnumber:carnumber,
          Starttime:startime,
          Endtime:endtime,
          Duratime:duratime,
          Consume:consum
        })
        console.log(that.data.Carnumber);
        
        //判断车牌号是否存在
        if (data.logid != 0) {
          signal = true;
        }
        if (signal == false) {
          wx.showToast({
            title: '车牌号不存在！',
            icon: 'loading'
          })
        }
        else {
          /*
          that.setData({
            Carid: carid,
            Carnumber: carnumber,
            Starttime: startime,
            Endtime: endtime,
            Duratime: duratime,
            Consume: consum
          })
          */
          wx.navigateTo({
            url: '/pages/checkpage/checkpage?carid=' + that.data.Carid + '&starttime=' + that.data.Starttime + '&endtime=' + that.data.Endtime + '&duratime=' + that.data.Duratime + '&consume=' + that.data.Consume + '&carnumber=' + that.data.Carnumber,
          })
        }
      }
    })

  },
})