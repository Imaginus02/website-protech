(function(){"use strict";var e={3567:function(e,s,n){var t=n(9242),o=n(3396);const i={class:"main-content w-50 mx-auto"};function r(e,s,n,t,r,a){const c=(0,o.up)("MainNavigation"),u=(0,o.up)("SessionList");return(0,o.wg)(),(0,o.iD)("section",i,[(0,o.Wm)(c,{onSessions:s[0]||(s[0]=e=>a.show("sessions")),onCodes:s[1]||(s[1]=e=>a.show("codes")),onProfile:s[2]||(s[2]=e=>a.show("profile"))}),"sessions"===this.selected?((0,o.wg)(),(0,o.j4)(u,{key:0})):(0,o.kq)("",!0)])}var a=n(7139);const c={class:"nav nav-tabs"};function u(e,s,n,t,i,r){return(0,o.wg)(),(0,o.iD)("ul",c,[(0,o._)("li",{class:"nav-item",onClick:s[0]||(s[0]=e=>r.setActiveTab("sessions"))},[(0,o._)("a",{class:(0,a.C_)(["nav-link",{active:"sessions"===i.activeTab}]),"aria-current":"page",href:"#"},"Sessions",2)]),(0,o._)("li",{class:"nav-item",onClick:s[1]||(s[1]=e=>r.setActiveTab("codes"))},[(0,o._)("a",{class:(0,a.C_)(["nav-link",{active:"codes"===i.activeTab}]),href:"#",tabindex:"-1","aria-disabled":"true"},"Codes",2)]),(0,o._)("li",{class:"nav-item",onClick:s[2]||(s[2]=e=>r.setActiveTab("profile"))},[(0,o._)("a",{class:(0,a.C_)(["nav-link",{active:"profile"===i.activeTab}]),href:"#",tabindex:"-1","aria-disabled":"true"},"Profile",2)])])}var l={name:"app",emits:["sessions","codes","profile"],data(){return{activeTab:"sessions"}},methods:{setActiveTab(e){this.activeTab=e,this.$emit(this.activeTab),console.log("Changing active tab to : "+this.activeTab)}}},d=n(89);const v=(0,d.Z)(l,[["render",u]]);var f=v;const p={class:"sessions-list pt-3"};function m(e,s,n,t,i,r){const a=(0,o.up)("session-list-item");return(0,o.wg)(),(0,o.iD)("div",p,[((0,o.wg)(!0),(0,o.iD)(o.HY,null,(0,o.Ko)(e.sessions,(e=>((0,o.wg)(),(0,o.j4)(a,{session:e,key:e.id},null,8,["session"])))),128))])}const b={class:"building border border-secondary rounded p-2 mb-2"},h={class:"top-row d-flex"},w={class:"window-name fw-bold pe-3"},g={class:"room-name text-muted"},_={class:"room-name text-muted"},k={class:"room-name text-muted"},x={class:"room-name text-muted"};function T(e,s,n,t,i,r){return(0,o.wg)(),(0,o.iD)("div",b,[(0,o._)("div",h,[(0,o._)("div",w,(0,a.zw)(n.session.name),1),(0,o._)("div",g,"Id de la session : "+(0,a.zw)(n.session.password),1),(0,o._)("div",_,"Date de création : "+(0,a.zw)(n.session.startDate),1),(0,o._)("div",k,"Date de fin : "+(0,a.zw)(n.session.endDate),1),(0,o._)("div",x,"Nombre d'utilisateur maximum : "+(0,a.zw)(n.session.nombreMax),1)])])}var y={name:"SessionListItem",props:["session"]};const C=(0,d.Z)(y,[["render",T]]);var O=C,j={components:{SessionListItem:O},name:"SessionList",data:function(){return{sessions:[]}},created:async function(){fetch("/api/sessions").then((e=>{if(!e.ok)throw new Error("Server reponse was not ok");return console.log(e),e.json()})).then((e=>{console.log(e),this.sessions=e}))}};const D=(0,d.Z)(j,[["render",m]]);var S=D,z={name:"App",components:{SessionList:S,MainNavigation:f},data:function(){return{selected:"sessions"}},methods:{show(e){this.selected=e}}};const A=(0,d.Z)(z,[["render",r],["__scopeId","data-v-f31d2226"]]);var L=A;(0,t.ri)(L).mount("#app")}},s={};function n(t){var o=s[t];if(void 0!==o)return o.exports;var i=s[t]={exports:{}};return e[t].call(i.exports,i,i.exports,n),i.exports}n.m=e,function(){var e=[];n.O=function(s,t,o,i){if(!t){var r=1/0;for(l=0;l<e.length;l++){t=e[l][0],o=e[l][1],i=e[l][2];for(var a=!0,c=0;c<t.length;c++)(!1&i||r>=i)&&Object.keys(n.O).every((function(e){return n.O[e](t[c])}))?t.splice(c--,1):(a=!1,i<r&&(r=i));if(a){e.splice(l--,1);var u=o();void 0!==u&&(s=u)}}return s}i=i||0;for(var l=e.length;l>0&&e[l-1][2]>i;l--)e[l]=e[l-1];e[l]=[t,o,i]}}(),function(){n.n=function(e){var s=e&&e.__esModule?function(){return e["default"]}:function(){return e};return n.d(s,{a:s}),s}}(),function(){n.d=function(e,s){for(var t in s)n.o(s,t)&&!n.o(e,t)&&Object.defineProperty(e,t,{enumerable:!0,get:s[t]})}}(),function(){n.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(e){if("object"===typeof window)return window}}()}(),function(){n.o=function(e,s){return Object.prototype.hasOwnProperty.call(e,s)}}(),function(){var e={143:0};n.O.j=function(s){return 0===e[s]};var s=function(s,t){var o,i,r=t[0],a=t[1],c=t[2],u=0;if(r.some((function(s){return 0!==e[s]}))){for(o in a)n.o(a,o)&&(n.m[o]=a[o]);if(c)var l=c(n)}for(s&&s(t);u<r.length;u++)i=r[u],n.o(e,i)&&e[i]&&e[i][0](),e[i]=0;return n.O(l)},t=self["webpackChunkwebsite_protech_vue"]=self["webpackChunkwebsite_protech_vue"]||[];t.forEach(s.bind(null,0)),t.push=s.bind(null,t.push.bind(t))}();var t=n.O(void 0,[998],(function(){return n(3567)}));t=n.O(t)})();
//# sourceMappingURL=app.js.map