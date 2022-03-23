const webpack = require("webpack");
module.exports = {
    devServer: {
        proxy: {  //配置跨域
            '/api': {
                // target: 'http://39.107.252.30:8083/',  //这里后台的地址模拟的;应该填写你们真实的后台接口
                target: 'http://localhost:8083/',  //这里后台的地址模拟的;应该填写你们真实的后台接口
                changOrigin: true,  //允许跨域
                pathRewrite: {
                    '^/api': ''
                }
            },
        }
    },
    publicPath: '/',
    configureWebpack: {
        plugins: [
            new webpack.ProvidePlugin({
                $: "jquery",
                jQuery: "jquery",
                "window.jQuery": "jquery",
                "window.$": "jquery",
                Popper: ["popper.js", "default"]
            })
        ]
    }
}


