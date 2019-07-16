//index.js
//获取应用实例
const app = getApp()

Page({
  data:{
    user_radioCheckValue: 1,
    adm_radioCheckValue: 0,
    tmp:5,

    
  },
  
  //身份radio切换
  radioChange: function(e) {
    var that=this;
    this.data.tmp=this.data.user_radioCheckValue;
    this.data.user_radioCheckValue=this.data.adm_radioCheckValue
    this.data.adm_radioCheckValue=this.data.tmp;
    that.setData({
      user_radioCheckValue: this.data.user_radioCheckValue,
      adm_radioCheckValue: this.data.adm_radioCheckValue
    })
  },

  //表单提交
  formSubmit: function(e) {

    var signal = false;
    var adminjudge = false;

    var that=this;

      //获取表单数据
      var vstatus=e.detail.value.status;
      var vcarNumber=e.detail.value.carNumber;
      var vadminName=e.detail.value.adminName;
      var vadminPsw=e.detail.value.adminPsw;

      //判断身份，如果是车主
      if(vstatus=="车主") {
        if(vcarNumber.length==0) {
          wx.showToast({
            title: '请输入车牌号',
            icon: 'loading',
            duration: 1500
          })
        }
        else {
          //将车牌号传到后端
          wx.request({
            url: 'http://localhost:8080/Parking/carselect?carnum='+vcarNumber,
            header: {
              'content-type': 'application/json' //默认值
            },
            method: "GET",
            success: function (res) {
              console.log(res.data);
              let data = res.data;
              let carid = data.carId;
              let startTime = data.startTime;
          
              if(data.carId != 0) {
                signal = true;
              }
              if(signal == false) {
                wx.showToast({
                  title: '车牌号不存在！',
                  icon: 'loading'
                })
              }
              else {
                wx.navigateTo({
                  url: '/pages/userpage/userpage?carid='+carid+'&carnum='+vcarNumber+'&stime='+startTime,
                })
              }
            }
          })
          
        }
      }
      //如果是管理员
      else {
        if(vadminName.length==0||vadminPsw.length==0) {
          wx.showToast({
            title: '账号或密码为空',
            icon: 'loading',
            duration: 1500
          })
        }
        else {
          //验证管理员账号和密码
          wx.request({
            url: 'http://localhost:8080/Parking/admincheck?adminId='+vadminName+'&adminPassword='+vadminPsw,
            header: {
              'content-type': 'application/json'
            },
            method: "GET",
            success: function(res) {
              console.log(res.data);
              let data = res.data;
              if(data.ifright == true) {
                adminjudge = true;
              }
              if (adminjudge == false) {
                wx.showToast({
                  title: '账号或密码错误',
                  icon: 'loading'
                })
              }
              else {
                wx.navigateTo({
                  url: '/pages/adminpage/adminpage',
                })
              }
            }
          })    

        }
        
      }
  },
})
