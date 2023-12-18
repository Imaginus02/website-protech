(function(){"use strict";var e={7716:function(e,s,n){var t=n(9242),o=n(3396);const r={class:"main-content w-50 mx-auto"};function i(e,s,n,t,i,a){const c=(0,o.up)("MainNavigation"),u=(0,o.up)("SessionList"),d=(0,o.up)("CodeList"),l=(0,o.up)("UserList");return(0,o.wg)(),(0,o.iD)("section",r,[(0,o.Wm)(c,{onSessions:s[0]||(s[0]=e=>a.show("sessions")),onCodes:s[1]||(s[1]=e=>a.show("codes")),onProfile:s[2]||(s[2]=e=>a.show("profile"))}),"sessions"===this.selected?((0,o.wg)(),(0,o.j4)(u,{key:0})):(0,o.kq)("",!0),"codes"===this.selected?((0,o.wg)(),(0,o.j4)(d,{key:1})):(0,o.kq)("",!0),"profile"===this.selected?((0,o.wg)(),(0,o.j4)(l,{key:2})):(0,o.kq)("",!0)])}var a=n(7139);const c={class:"nav nav-tabs"};function u(e,s,n,t,r,i){return(0,o.wg)(),(0,o.iD)("ul",c,[(0,o._)("li",{class:"nav-item",onClick:s[0]||(s[0]=e=>i.setActiveTab("sessions"))},[(0,o._)("a",{class:(0,a.C_)(["nav-link",{active:"sessions"===r.activeTab}]),"aria-current":"page",href:"#"},"Sessions",2)]),(0,o._)("li",{class:"nav-item",onClick:s[1]||(s[1]=e=>i.setActiveTab("codes"))},[(0,o._)("a",{class:(0,a.C_)(["nav-link",{active:"codes"===r.activeTab}]),href:"#",tabindex:"-1","aria-disabled":"true"},"Codes",2)]),(0,o._)("li",{class:"nav-item",onClick:s[2]||(s[2]=e=>i.setActiveTab("profile"))},[(0,o._)("a",{class:(0,a.C_)(["nav-link",{active:"profile"===r.activeTab}]),href:"#",tabindex:"-1","aria-disabled":"true"},"Profile",2)])])}var d={name:"app",emits:["sessions","codes","profile"],data(){return{activeTab:"sessions"}},methods:{setActiveTab(e){this.activeTab=e,this.$emit(this.activeTab),console.log("Changing active tab to : "+this.activeTab)}}},l=n(89);const p=(0,l.Z)(d,[["render",u]]);var m=p;const f={class:"sessions-list pt-3"},v={key:0,class:"fw-bold"};function b(e,s,n,t,r,i){const a=(0,o.up)("session-list-item");return(0,o.wg)(),(0,o.iD)("div",f,[0===e.sessions.length?((0,o.wg)(),(0,o.iD)("p",v,"Aucune Session créée")):((0,o.wg)(!0),(0,o.iD)(o.HY,{key:1},(0,o.Ko)(e.sessions,(e=>((0,o.wg)(),(0,o.j4)(a,{session:e,key:e.id},null,8,["session"])))),128))])}const w={class:"building border border-secondary rounded p-2 mb-2"},h={class:"top-row d-flex"},g={class:"fw-bold pe-3"},y={class:"text-muted"},_={class:"text-muted"},k={class:"text-muted"},C={class:"text-muted"};function I(e,s,n,t,r,i){return(0,o.wg)(),(0,o.iD)("div",w,[(0,o._)("div",h,[(0,o._)("div",g,(0,a.zw)(n.session.name),1),(0,o._)("div",y,"Id de la session : "+(0,a.zw)(n.session.password),1),(0,o._)("div",_,"Date de création : "+(0,a.zw)(n.session.startDate),1),(0,o._)("div",k,"Date de fin : "+(0,a.zw)(n.session.endDate),1),(0,o._)("div",C,"Nombre d'utilisateur maximum : "+(0,a.zw)(n.session.nombreMax),1)])])}var S={name:"SessionListItem",props:["session"]};const x=(0,l.Z)(S,[["render",I]]);var D=x,j={components:{SessionListItem:D},name:"SessionList",data:function(){return{sessions:[]}},created:async function(){fetch("/api/sessions").then((e=>{if(!e.ok)throw new Error("Server response was not ok");return console.log(e),e.json()})).then((e=>{console.log(e),this.sessions=e}))}};const L=(0,l.Z)(j,[["render",b]]);var T=L;const F={class:"codes-list pt-3"};function O(e,s,n,t,r,i){const a=(0,o.up)("CodeListItem");return(0,o.wg)(),(0,o.iD)("div",F,[((0,o.wg)(!0),(0,o.iD)(o.HY,null,(0,o.Ko)(e.codes,(e=>((0,o.wg)(),(0,o.j4)(a,{code:e,key:e.id},null,8,["code"])))),128))])}const U={class:"building border border-secondary rounded p-2 mb-2"},M={class:"fw-bold pe-3"},z=(0,o._)("hr",null,null,-1),Z=(0,o._)("button",{class:"btn btn-danger"},"Supprimer",-1);function A(e,s,n,t,r,i){const c=(0,o.up)("InstructionListItem");return(0,o.wg)(),(0,o.iD)("div",U,[(0,o._)("div",M,(0,a.zw)(n.code.name),1),((0,o.wg)(!0),(0,o.iD)(o.HY,null,(0,o.Ko)(i.sortedInstructions,(e=>((0,o.wg)(),(0,o.j4)(c,{instruction:e,key:e.id},null,8,["instruction"])))),128)),z,Z])}const H=(0,o._)("hr",null,null,-1),E={class:"text-muted"};function P(e,s,n,t,r,i){return(0,o.wg)(),(0,o.iD)(o.HY,null,[H,(0,o._)("div",E,(0,a.zw)(n.instruction.name),1)],64)}var N={name:"InstructionListItem",props:["instruction"]};const Y=(0,l.Z)(N,[["render",P]]);var K=Y,q={components:{InstructionListItem:K},name:"CodeListItem",props:["code"],computed:{sortedInstructions(){return this.code.instructions.slice().sort(((e,s)=>e.orderInCode-s.orderInCode))}}};const $=(0,l.Z)(q,[["render",A]]);var J=$,V={components:{CodeListItem:J},name:"CodeList",data:function(){return{codes:[]}},created:async function(){fetch("/api/codes").then((e=>{if(!e.ok)throw new Error("Server response was not ok");return console.log(e),e.json()})).then((e=>{console.log(e),this.codes=e}))}};const W=(0,l.Z)(V,[["render",O]]);var B=W;const G={class:"user-list pt-3"};function Q(e,s,n,t,r,i){const a=(0,o.up)("UserListItem");return(0,o.wg)(),(0,o.iD)("div",G,[((0,o.wg)(!0),(0,o.iD)(o.HY,null,(0,o.Ko)(e.users,(e=>((0,o.wg)(),(0,o.j4)(a,{user:e,key:e.id},null,8,["user"])))),128))])}const R={class:"border border-secondary rounded p-2 mb-2"},X={class:"top-row d-flex"},ee={class:"fw-bold pe-3"},se=(0,o._)("hr",null,null,-1),ne={class:"d-flex"},te={class:"text-muted pe-3"},oe=(0,o._)("hr",null,null,-1),re={class:"d-flex"},ie={class:"text-muted pe-3"},ae=(0,o._)("hr",null,null,-1),ce=(0,o._)("div",{class:"bottom-row d-flew"},[(0,o._)("button",{class:"btn btn-danger"},"Supprimer")],-1);function ue(e,s,n,t,r,i){const c=(0,o.up)("UserForm");return(0,o.wg)(),(0,o.iD)("div",R,[(0,o._)("div",X,[(0,o._)("div",ee,"Nom d'utilisateur : "+(0,a.zw)(n.user.username),1),r.usernameForm?((0,o.wg)(),(0,o.j4)(c,{key:1,userInput:"username",id:n.user.id,onCancel:s[1]||(s[1]=e=>r.usernameForm=!1)},null,8,["id"])):((0,o.wg)(),(0,o.iD)("button",{key:0,class:"btn btn-secondary ms-auto",onClick:s[0]||(s[0]=e=>r.usernameForm=!0)},"Modifier"))]),se,(0,o._)("div",ne,[(0,o._)("div",te,"Email : "+(0,a.zw)(n.user.email),1),r.emailForm?((0,o.wg)(),(0,o.j4)(c,{key:1,userInput:"email",id:n.user.id,onCancel:s[3]||(s[3]=e=>r.emailForm=!1)},null,8,["id"])):((0,o.wg)(),(0,o.iD)("button",{key:0,class:"btn btn-secondary ms-auto",onClick:s[2]||(s[2]=e=>r.emailForm=!0)},"Modifier"))]),oe,(0,o._)("div",re,[(0,o._)("div",ie,"Mot de passe : "+(0,a.zw)(n.user.password),1),r.passwordForm?((0,o.wg)(),(0,o.j4)(c,{key:1,userInput:"password",id:n.user.id,onCancel:s[5]||(s[5]=e=>r.passwordForm=!1)},null,8,["id"])):((0,o.wg)(),(0,o.iD)("button",{key:0,class:"btn btn-secondary ms-auto",onClick:s[4]||(s[4]=e=>r.passwordForm=!0)},"Modifier"))]),ae,ce])}const de=(0,o._)("button",{type:"submit",class:"btn btn-primary"},"Modifier",-1);function le(e,s,n,r,i,a){return(0,o.wg)(),(0,o.iD)("form",{onSubmit:s[2]||(s[2]=(0,t.iM)(((...e)=>a.handleSubmit&&a.handleSubmit(...e)),["prevent"]))},[(0,o.wy)((0,o._)("input",{"onUpdate:modelValue":s[0]||(s[0]=e=>i.userInput=e),type:"text",class:"form-control mb-3 space-between-elements"},null,512),[[t.nr,i.userInput]]),de,(0,o._)("button",{type:"button",class:"btn btn-secondary",onClick:s[1]||(s[1]=e=>this.$emit("cancel"))},"Annuler")],32)}var pe={name:"UserForm",props:["usage","id"],data(){return{userInput:"",endpoint:"/api/users",dataToSend:{}}},methods:{async handleSubmit(){this.endpoint="/api/users/"+String(this.id),""===this.userInput?console.log("Missing argument"):(this.dataToSend={usage:this.userInput},fetch(this.endpoint,{method:"PATCH",headers:{"Content-type":"application/json"},body:JSON.stringify(this.dataToSend)}).then((e=>{if(!e.ok)throw new Error(`HTTP error! Status: ${e.status}`);return e.json()})).then((e=>{console.log("Update successful:",e)})).catch((e=>{console.error("Update failed:",e.message)})))}}};const me=(0,l.Z)(pe,[["render",le]]);var fe=me,ve={name:"UserListItem",components:{UserForm:fe},props:["user"],data(){return{usernameForm:!1,emailForm:!1,passwordForm:!1}}};const be=(0,l.Z)(ve,[["render",ue]]);var we=be,he={name:"UserList",components:{UserListItem:we},data:function(){return{users:[]}},created:async function(){fetch("/api/users").then((e=>{if(!e.ok)throw new Error("Server response was not ok");return console.log(e),e.json()})).then((e=>{console.log(e),this.users=e}))}};const ge=(0,l.Z)(he,[["render",Q]]);var ye=ge,_e={name:"App",components:{UserList:ye,CodeList:B,SessionList:T,MainNavigation:m},data:function(){return{selected:"sessions"}},methods:{show(e){this.selected=e}}};const ke=(0,l.Z)(_e,[["render",i],["__scopeId","data-v-6bf1aa0d"]]);var Ce=ke;(0,t.ri)(Ce).mount("#app")}},s={};function n(t){var o=s[t];if(void 0!==o)return o.exports;var r=s[t]={exports:{}};return e[t].call(r.exports,r,r.exports,n),r.exports}n.m=e,function(){var e=[];n.O=function(s,t,o,r){if(!t){var i=1/0;for(d=0;d<e.length;d++){t=e[d][0],o=e[d][1],r=e[d][2];for(var a=!0,c=0;c<t.length;c++)(!1&r||i>=r)&&Object.keys(n.O).every((function(e){return n.O[e](t[c])}))?t.splice(c--,1):(a=!1,r<i&&(i=r));if(a){e.splice(d--,1);var u=o();void 0!==u&&(s=u)}}return s}r=r||0;for(var d=e.length;d>0&&e[d-1][2]>r;d--)e[d]=e[d-1];e[d]=[t,o,r]}}(),function(){n.n=function(e){var s=e&&e.__esModule?function(){return e["default"]}:function(){return e};return n.d(s,{a:s}),s}}(),function(){n.d=function(e,s){for(var t in s)n.o(s,t)&&!n.o(e,t)&&Object.defineProperty(e,t,{enumerable:!0,get:s[t]})}}(),function(){n.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(e){if("object"===typeof window)return window}}()}(),function(){n.o=function(e,s){return Object.prototype.hasOwnProperty.call(e,s)}}(),function(){var e={143:0};n.O.j=function(s){return 0===e[s]};var s=function(s,t){var o,r,i=t[0],a=t[1],c=t[2],u=0;if(i.some((function(s){return 0!==e[s]}))){for(o in a)n.o(a,o)&&(n.m[o]=a[o]);if(c)var d=c(n)}for(s&&s(t);u<i.length;u++)r=i[u],n.o(e,r)&&e[r]&&e[r][0](),e[r]=0;return n.O(d)},t=self["webpackChunkwebsite_protech_vue"]=self["webpackChunkwebsite_protech_vue"]||[];t.forEach(s.bind(null,0)),t.push=s.bind(null,t.push.bind(t))}();var t=n.O(void 0,[998],(function(){return n(7716)}));t=n.O(t)})();
//# sourceMappingURL=app.js.map