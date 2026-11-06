import { mapGetters as k } from "vuex";
import { openBlock as y } from "vue";
import { createElementBlock as O } from "vue";
import { createElementVNode as l } from "vue";
import { createBlock as Y } from "vue";
import { resolveDynamicComponent as j } from "vue";
import { T as w, P as q, L as E } from "./login/index.vue.js";
import { _ as x, U as P, H as U, g as $ } from "../../shared/runtime.js";
import F from "./menu/index.vue.js";
import z from "./register-company/index.vue.js";
import "./login/module/forgot-password.vue.js";
const A = { name: "Logo", computed: { ...k(["logo"]) } }, D = { class: "logo-container" }, N = ["src"];
function V(e, s, o, f, u, h) {
  return y(), O("div", D, [l("img", { class: "logo", src: e.logo }, null, 8, N)]);
}
const W = x(A, [["render", V], ["__scopeId", "data-v-62dd5890"]]);
const G = { name: "Wave", props: { waveColor: { type: Array, default: () => ["rgba(255, 255, 255, .3)", "rgba(255, 255, 255, .5)"] }, waveYOffset: { type: Number, default: 0 }, waveDuration: { type: Number, default: 3 } }, data() {
  return { offset: 0, waveOne: null, waveTwo: null, waveHeight: [0, 0], lastOptionOne: {}, lastOptionTwo: {} };
}, created() {
  const e = document.documentElement.clientHeight;
  this.waveHeight = [e * 0.03, e * 0.05];
}, mounted() {
  this.init();
}, beforeUnmount() {
  this.kill();
}, methods: { init() {
  const e = document.querySelector("body").getBoundingClientRect().height;
  this.lastOptionOne = { height: this.waveHeight[0], bones: 4, amplitude: 30, color: this.waveColor[0], speed: 0.15, waveYOffsetH: this.waveYOffset * e - this.offset }, this.lastOptionTwo = { height: this.waveHeight[1], bones: 3, amplitude: 20, color: this.waveColor[1], speed: 0.25, waveYOffsetH: this.waveYOffset * e - this.offset }, this.waveOne = this.wavify("#feel-the-wave", this.lastOptionOne), this.waveTwo = this.wavify("#feel-the-wave-two", this.lastOptionTwo);
}, refresh() {
  const e = document.querySelector("body").getBoundingClientRect().height, s = { height: this.waveHeight[0], bones: 4, amplitude: 30, color: this.waveColor[0], speed: 0.15, waveYOffsetH: this.waveYOffset * e - this.offset }, o = { height: this.waveHeight[1], bones: 3, amplitude: 20, color: this.waveColor[1], speed: 0.25, waveYOffsetH: this.waveYOffset * e - this.offset };
  this.waveOne.reboot(s, Object.assign({}, this.lastOptionOne), this.waveDuration), this.waveTwo.reboot(o, Object.assign({}, this.lastOptionTwo), this.waveDuration), this.lastOptionOne = s, this.lastOptionTwo = o;
}, kill() {
  this.waveOne.kill(), this.waveTwo.kill();
}, pause() {
  const e = document.getElementById("feel-the-wave"), s = document.getElementById("feel-the-wave-two");
  e && s && (this.waveOne.pause(), this.waveTwo.pause());
}, play() {
  const e = document.getElementById("feel-the-wave"), s = document.getElementById("feel-the-wave-two");
  e && s && (this.waveOne.play(), this.waveTwo.play());
}, wavify(e, s) {
  typeof s > "u" && (s = {});
  var o = Object.assign({}, { container: s.container ? s.container : "body", height: 200, amplitude: 100, speed: 0.15, bones: 3, color: "rgba(255,255,255, 0.20)" }, s);
  const f = e;
  let u = document.querySelector(o.container).getBoundingClientRect().width, h = document.querySelector(o.container).getBoundingClientRect().height, g, _ = 0, d = false, v = false;
  function R(t) {
    o = Object.assign({}, { container: s.container ? s.container : "body", height: 200, amplitude: 100, speed: 0.15, bones: 3, color: "rgba(255,255,255, 0.20)" }, t);
  }
  function H(t) {
    for (var a = [], n = 0; n <= o.bones; n++) {
      var i = n / o.bones * u, r = (t + (n + n % o.bones)) * o.speed * 100, c = Math.sin(r / 100) * o.amplitude, I = Math.sin(r / 100) * c + o.height;
      a.push({ x: i, y: I });
    }
    return a;
  }
  function L(t) {
    var a = "M " + t[0].x + " " + t[0].y, n = { x: (t[1].x - t[0].x) / 2, y: t[1].y - t[0].y + t[0].y + (t[1].y - t[0].y) };
    a += " C " + n.x + " " + n.y + " " + n.x + " " + n.y + " " + t[1].x + " " + t[1].y;
    for (var i = n, r = 1; r < t.length - 1; r++) {
      Math.sqrt(i.x * i.x + i.y * i.y);
      var c = { x: t[r].x - i.x + t[r].x, y: t[r].y - i.y + t[r].y };
      a += " C " + c.x + " " + c.y + " " + c.x + " " + c.y + " " + t[r + 1].x + " " + t[r + 1].y, i = c;
    }
    return a += " L " + u + " " + h, a += " L 0 " + h + " Z", a;
  }
  function C() {
    var t = window.Date.now();
    if (g) {
      var a = (t - g) / 1e3;
      g = t, _ += a;
      var n = _ * Math.PI;
      v = w.to(f, o.speed, { attr: { d: L(H(n)) }, ease: q.easeInOut });
    } else g = t;
    d = requestAnimationFrame(C);
  }
  function M(t, a, n) {
    var i;
    return () => {
      const r = this, c = arguments;
      clearTimeout(i), i = setTimeout(() => {
        i = null, n || t.apply(r, c);
      }, a), n && !i && t.apply(r, c);
    };
  }
  var m = M(() => {
    b(), _ = 0, u = document.querySelector(o.container).getBoundingClientRect().width, h = document.querySelector(o.container).getBoundingClientRect().height, g = false, p();
  }, 250);
  function S() {
    d || (v = w.set(f, { y: o.waveYOffsetH, attr: { fill: o.color } }), p(), window.addEventListener("resize", m, { passive: false }));
  }
  function B(t, a, n) {
    T(), typeof t !== void 0 && R(t), v = w.fromTo(f, n, { y: a.waveYOffsetH, attr: { fill: a.color } }, { y: o.waveYOffsetH || 0, attr: { fill: o.color } }), p(), window.addEventListener("resize", m, { passive: false });
  }
  function p() {
    d || (d = requestAnimationFrame(C), window.addEventListener("resize", m, { passive: false }));
  }
  function b() {
    d && (cancelAnimationFrame(d), d = false, window.removeEventListener("resize", m));
  }
  function T() {
    d && (b(), v.kill(), v = w.set(f, { x: 0, y: 0, rotation: 0, opacity: 0, clearProps: "all", attr: { d: "M0,0", fill: "" } }), d = false), window.removeEventListener("resize", m);
  }
  return S(), { reboot: B, play: p, pause: b, kill: T };
} } }, Z = { class: "component-container" };
function Q(e, s, o, f, u, h) {
  return y(), O("div", Z, s[0] || (s[0] = [l("svg", { width: "100%", height: "100%", version: "1.1", xmlns: "http://www.w3.org/2000/svg", class: "wave" }, [l("defs"), l("path", { id: "feel-the-wave", d: "" })], -1), l("svg", { width: "100%", height: "100%", version: "1.1", xmlns: "http://www.w3.org/2000/svg", class: "wave" }, [l("defs"), l("path", { id: "feel-the-wave-two", d: "" })], -1)]));
}
const J = x(G, [["render", Q], ["__scopeId", "data-v-5a9af9cd"]]), K = "/static/jpg/background-082192ef.jpg", X = "/static/png/ZhongNan-logo-852ffde2.png";
const ee = { name: "LoginAndMenu", components: { Logo: W, UserHeader: P, Wave: J, Login: E, Menus: F, RegCompany: z, HeadSwitchProject: U }, data() {
  return { showLogin: true, showRegCompany: true, waveColor: ["rgba(255, 255, 255, .3)", "rgba(255, 255, 255, .5)"], waveYOffset: 0.9 };
}, computed: { ...k(["token", "menus", "homePageShowConfig"]), currentView() {
  return this.showRegCompany ? "reg-company" : "login";
} }, created() {
  $() && (this.showRegCompany = false), this.token && (this.showLogin = false);
}, mounted() {
  this.token && (this.homePageShowConfig ? this.$router.push("/") : this.jumpToFirstMenu());
}, activated() {
  this.$refs.wave.play();
}, beforeUnmount() {
}, methods: { jumpToFirstMenu() {
  const e = this.menus.findIndex((s) => !s.iframe);
  if (e === -1) return this.$router.push({ path: "/iframe" });
  this.$router.push(this.menus[e].redirect);
}, loginCallback(e) {
  e && e.success && (this.homePageShowConfig ? this.$router.push("/") : this.jumpToFirstMenu());
}, regCompanyCallback(e) {
  e === true && $() && (this.showRegCompany = false);
}, replaceCallback(e) {
  e && this.$refs.wave && this.$refs.wave.pause();
}, clearRequestUrl() {
  this.showRegCompany = true;
}, showMenu() {
  this.showLogin = false, this.$nextTick(() => {
    this.waveRise(), this.showUserHeader(), this.showMenuTween();
  });
}, showUserHeader() {
  this.menuTween = w.from("#rightDrawer", 1e3 / 1e3, { opacity: 0 });
}, showMenuTween() {
  this.menuTween = w.from("#menus", 2e3 / 1e3, { opacity: 0 });
}, getOtherQuery(e) {
  return Object.keys(e).reduce((s, o) => (o !== "redirect" && (s[o] = e[o]), s), {});
}, waveRise() {
  this.waveColor = ["rgba(58, 142, 230, .3)", "rgba(58, 142, 230, .5)"], this.waveYOffset = 0, this.$nextTick(() => {
    this.$refs.wave.refresh();
  });
} } }, te = { class: "login-menus-container" }, se = { class: "login-right" };
function oe(e, s, o, f, u, h) {
  return y(), O("div", te, [s[1] || (s[1] = l("div", { class: "login-left" }, [l("img", { class: "background", src: K }), l("img", { class: "logo", src: X })], -1)), l("div", se, [(y(), Y(j(h.currentView), { style: { "z-index": "2" }, onRegResult: h.regCompanyCallback, onLogin: h.loginCallback, onShowRegCompany: h.clearRequestUrl }, null, 40, ["onRegResult", "onLogin", "onShowRegCompany"])), s[0] || (s[0] = l("div", { class: "versions" }, "© 初鸣数智V7.0", -1))])]);
}
const ce = x(ee, [["render", oe], ["__scopeId", "data-v-02469ea1"]]);
export {
  ce as default
};
