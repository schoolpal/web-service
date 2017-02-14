const path = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const ROOT_PATH = path.resolve(__dirname);
const DEV_PATH = path.resolve(ROOT_PATH, 'src');
const BUILD_PATH = path.resolve(ROOT_PATH, 'static/dist');

module.exports = {
    entry: path.resolve(DEV_PATH, 'app.jsx'),
    output: {
        path: BUILD_PATH,
        filename: 'bundle.js',
        publicPath: '/dist/'
    },
    module: {
        loaders: [{
            test: /\.jsx?$/,
            loader: 'babel',
            include: DEV_PATH,
            query: {
                presets: ['es2015', 'react']
            }
        }, {
            test: /\.less$/,
            loader: 'style-loader!css-loader!less-loader'
        }, {
            test: /\.(png|jpg)$/,
            loader: 'url?limit=8192'
        }, {
            test: /\.(gif|jpg|png|woff|svg|eot|ttf)\??.*$/,
            loader: 'url'
        }]
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: path.resolve(DEV_PATH, 'app.html'),
            filename: '../index.html'
        })
    ],
    resolve: {
        extensions: ['', '.js', '.jsx']
    }
}
