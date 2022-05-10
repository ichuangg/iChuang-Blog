const webpack = require("webpack");
const path = require('path');
const CompressionWebpackPlugin = require('compression-webpack-plugin')
const productionGzipExtensions = ['js', 'css']

module.exports = {
    productionSourceMap: false,

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
    configureWebpack: {
        resolve: {
            alias: {
                '@': path.resolve(__dirname, './src'),
                '@i': path.resolve(__dirname, './src/assets'),
            }
        },
        plugins: [
            new webpack.IgnorePlugin(/^\.\/locale$/, /moment$/),

            // 下面是下载的插件的配置
            new CompressionWebpackPlugin({
                algorithm: 'gzip',
                test: new RegExp('\\.(' + productionGzipExtensions.join('|') + ')$'),
                threshold: 10240,
                minRatio: 0.8
            }),
            new webpack.optimize.LimitChunkCountPlugin({
                maxChunks: 5,
                minChunkSize: 100
            })
        ]
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


