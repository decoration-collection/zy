// 按需编译，只编译用到的资源
fis.set('project.files', ['*.*']);

//// 采用 commonJs 规范支持模块化组建开发
//fis.hook('commonJs', {
//  packages: [
//
//    // 短路径支持
//    // 可以通过 require('/libs/alert') 依赖 `static/libs/alert.js`
//    {
//      name: 'libs',
//      location: './static/libs'
//    }
//  ]
//});

//任何以_开头的文件或文件名都不要release,static文件夹是产出文件夹不要处理
fis.match(/(.*\/_.*|\/file-static\/*|\/.+\.md)/i, {
    release: false
});

// files文件夹放置不需要编译的静态文件，比如广告图、文档、压缩包等
fis.match( /^(\/files\/.*)$/i, {
   release : '$1',
   url: '$1',
   useHash: false,
   useCompile: false
});

fis.match(/^(.*)/i, {
    release: '/$1',
    url: '/zy$1'
});

// //topics文件夹下的less需要编译
// fis.match(/\/www(\/.*\.(?:js|less))$/i, {
//     release : '/www$1',
//     url: '$1',
//     useHash: false,
//     useOptimizer: false,
//     useCompile: true
// });

//已经压缩的资源不要再次压缩，二次压缩会导致非常慢的编译速度
fis.match(/^(.*\/.+\.min\.(?:js|css|less))$/i, {
   release : '$1',
   url: '$1',
   useOptimizer: false
});

// //已经压缩的资源不要再次压缩，二次压缩会导致非常慢的编译速度
// fis.match(/\/www(.*\/.+\.min\.(?:js|css|less))$/i, {
//     release : '/www$1',
//     url: '$1',
//     useOptimizer: false
// });

//// 默认认为所有的资源都是静态资源，放在  目录下面
//fis.match('**', {
//  release: '/web/files/$0',
//  url: '/files/$0'
//});

// static 下面本来就是静态资源，去掉多出来的一层目录。
//fis.match('/static/(**)', {
//  release: '/$1',
//  url: '$1'
//});

//// 省掉 page 这个目录。
//fis.match('/page/(**.blade.php)', {
//    release: '/resources/views/$1',
//    url: "$1"
//});

// // 配置 map.json 产出路径。
// fis.match('/map.json', {
//     release: '/map/map.json'
// });
//
// // 让所有的 js 都用模块化的方式开发。
// fis.match('*.js', {
//     isMod: true
// });
//
// // static/js 下面放非模块化 js
// fis.match('/static/js/*.js', {
//     isMod: false
// });
//
// // 给组件下面的 js 设置同名依赖
// fis.match('/components/**.js', {
//     useSameNameRequire: true
// });

// 支持前端模板，支持 js 内嵌后，直接翻译成可执行的 function
//fis.match('*.tmpl', {
//    parser: fis.plugin('utc'),
//    rExt: '.js',
//    release: false
//});

// fis.match('*.less', {
//     parser: fis.plugin('less'), //启用fis-parser-less插件
//     rExt: '.css'
// });

fis.match('*.less', {
    parser: 'less',
    rExt: '.css'
});

fis
    .media('test')

    .match(/\/www(.*)/i, {
        release: '/www$1',
        url: '$1'
    })

    .match(/\/www(\/.*\.(?:js|less))$/i, {
        release : '/www$1',
        url: '$1',
        useHash: false,
        useOptimizer: false,
        useCompile: true
    })

    .match(/\/www(.*\/.+\.min\.(?:js|css|less))$/i, {
        release : '/www$1',
        url: '$1',
        useOptimizer: false
    })

    .match('*.{js,css,png,less}', {
        useHash: true
    })

    .match('::package', {
        spriter: fis.plugin('csssprites')
    })

    .match('*.js', {
        optimizer: fis.plugin('uglify-js')
    })

    // .match('*.css', {
    //     optimizer: fis.plugin('clean-css')
    // })
    .match('*.{css,less}', {
        optimizer: fis.plugin('clean-css')
    })

    .match('*.png', {
        optimizer: fis.plugin('png-compressor')
    })

    // pack 相关
    .match('::package', {

        postpackager: fis.plugin('loader', {
            processor: {
                '.html': 'html',

                // 支持 markdown 文档
                '.md': 'html'
            },
            allInOne: true
        })

        // packager: fis.plugin('smart', {
        //     autoPack: true,
        //     cssInline: true
        // })
        //packager: fis.plugin('smart', {
        //    cssInline: true,
        //    autoPack: true
        //})
    });

// 在 prod 环境下，开启各种压缩和打包。
fis
    .media('prod')

    .match(/\/www(.*)/i, {
        release: '/www$1',
        url: '$1'
    })

    .match(/\/www(\/.*\.(?:js|less))$/i, {
        release : '/www$1',
        url: '$1',
        useHash: false,
        useOptimizer: false,
        useCompile: true
    })

    .match(/\/www(.*\/.+\.min\.(?:js|css|less))$/i, {
        release : '/www$1',
        url: '$1',
        useOptimizer: false
    })

    .match('*.{js,css,png,less}', {
        useHash: true
    })

    .match('::package', {
        spriter: fis.plugin('csssprites')
    })

    .match('*.js', {
        optimizer: fis.plugin('uglify-js')
    })

    // .match('*.css', {
    //     optimizer: fis.plugin('clean-css')
    // })
    .match('*.{css,less}', {
        optimizer: fis.plugin('clean-css')
    })

    .match('*.png', {
        optimizer: fis.plugin('png-compressor')
    })

    // pack 相关
    .match('::package', {

        postpackager: fis.plugin('loader', {
            processor: {
                '.html': 'html',

                // 支持 markdown 文档
                '.md': 'html'
            },
            allInOne: true
        })

        // packager: fis.plugin('smart', {
        //     autoPack: true,
        //     cssInline: true
        // })
        //packager: fis.plugin('smart', {
        //    cssInline: true,
        //    autoPack: true
        //})
    });
//.match('*.blade.php', {
//    loaderLang: 'html'
//})
//.match('::package', {
//    postpackager: fis.plugin('loader', {
//        allInOne: true
//    })
//});
//// libs 目录下面的 js 打成一个
//.match('/devolop/common/js/libs/**.js', {
//    packTo: '/web/common/js/lib/lib.js',
//    useHash: true
//});

//.match('*.{less,css}', {
//    packTo: '/static/aio.css',
//    useHash: true
//})
//
//.match('*.js', {
//    packTo: '/web/aio.js',
//    useHash: true
//});
