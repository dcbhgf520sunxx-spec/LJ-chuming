import { _ as c } from "../shared/runtime.js";
import { openBlock as p } from "vue";
import { createElementBlock as d } from "vue";
import { toDisplayString as f } from "vue";
let o = 0;
const u = "webkit moz ms o".split(" ");
let r, s;
const m = typeof window > "u";
if (m) r = function() {
}, s = function() {
};
else {
  r = window.requestAnimationFrame, s = window.cancelAnimationFrame;
  let t;
  for (let e = 0; e < u.length && !(r && s); e++) t = u[e], r = r || window[t + "RequestAnimationFrame"], s = s || window[t + "CancelAnimationFrame"] || window[t + "CancelRequestAnimationFrame"];
  (!r || !s) && (r = function(e) {
    const i = (/* @__PURE__ */ new Date()).getTime(), a = Math.max(0, 16 - (i - o)), l = window.setTimeout(() => {
      e(i + a);
    }, a);
    return o = i + a, l;
  }, s = function(e) {
    window.clearTimeout(e);
  });
}
const V = { props: { startVal: { type: Number, required: false, default: 0 }, endVal: { type: Number, required: false, default: 2017 }, duration: { type: Number, required: false, default: 3e3 }, autoplay: { type: Boolean, required: false, default: true }, decimals: { type: Number, required: false, default: 0, validator(t) {
  return t >= 0;
} }, decimal: { type: String, required: false, default: "." }, separator: { type: String, required: false, default: "," }, prefix: { type: String, required: false, default: "" }, suffix: { type: String, required: false, default: "" }, useEasing: { type: Boolean, required: false, default: true }, easingFn: { type: Function, default(t, e, i, a) {
  return i * (-Math.pow(2, -10 * t / a) + 1) * 1024 / 1023 + e;
} } }, data() {
  return { localStartVal: this.startVal, displayValue: this.formatNumber(this.startVal), printVal: null, paused: false, localDuration: this.duration, startTime: null, timestamp: null, remaining: null, rAF: null };
}, computed: { countDown() {
  return this.startVal > this.endVal;
} }, watch: { startVal() {
  this.autoplay && this.start();
}, endVal() {
  this.autoplay && this.start();
} }, mounted() {
  this.autoplay && this.start(), this.$emit("mountedCallback");
}, methods: { start() {
  this.localStartVal = this.startVal, this.startTime = null, this.localDuration = this.duration, this.paused = false, this.rAF = r(this.count);
}, pauseResume() {
  this.paused ? (this.resume(), this.paused = false) : (this.pause(), this.paused = true);
}, pause() {
  s(this.rAF);
}, resume() {
  this.startTime = null, this.localDuration = +this.remaining, this.localStartVal = +this.printVal, r(this.count);
}, reset() {
  this.startTime = null, s(this.rAF), this.displayValue = this.formatNumber(this.startVal);
}, count(t) {
  this.startTime || (this.startTime = t), this.timestamp = t;
  const e = t - this.startTime;
  this.remaining = this.localDuration - e, this.useEasing ? this.countDown ? this.printVal = this.localStartVal - this.easingFn(e, 0, this.localStartVal - this.endVal, this.localDuration) : this.printVal = this.easingFn(e, this.localStartVal, this.endVal - this.localStartVal, this.localDuration) : this.countDown ? this.printVal = this.localStartVal - (this.localStartVal - this.endVal) * (e / this.localDuration) : this.printVal = this.localStartVal + (this.endVal - this.localStartVal) * (e / this.localDuration), this.countDown ? this.printVal = this.printVal < this.endVal ? this.endVal : this.printVal : this.printVal = this.printVal > this.endVal ? this.endVal : this.printVal, this.displayValue = this.formatNumber(this.printVal), e < this.localDuration ? this.rAF = r(this.count) : this.$emit("callback");
}, isNumber(t) {
  return !isNaN(parseFloat(t));
}, formatNumber(t) {
  t = t.toFixed(this.decimals), t += "";
  const e = t.split(".");
  let i = e[0];
  const a = e.length > 1 ? this.decimal + e[1] : "", l = /(\d+)(\d{3})/;
  if (this.separator && !this.isNumber(this.separator)) for (; l.test(i); ) i = i.replace(l, "$1" + this.separator + "$2");
  return this.prefix + i + a + this.suffix;
} }, destroyed() {
  s(this.rAF);
} };
function y(t, e, i, a, l, b) {
  return p(), d("span", null, f(l.displayValue), 1);
}
const n = c(V, [["render", y]]);
function w(t, e, i) {
  return e in t ? Object.defineProperty(t, e, { value: i, enumerable: true, configurable: true, writable: true }) : t[e] = i, t;
}
function h(t, e) {
  var i = Object.keys(t);
  if (Object.getOwnPropertySymbols) {
    var a = Object.getOwnPropertySymbols(t);
    e && (a = a.filter(function(l) {
      return Object.getOwnPropertyDescriptor(t, l).enumerable;
    })), i.push.apply(i, a);
  }
  return i;
}
n.unmounted = n.destroyed, Reflect.deleteProperty(n, "destroyed");
var F = (function(t) {
  for (var e = 1; e < arguments.length; e++) {
    var i = arguments[e] != null ? arguments[e] : {};
    e % 2 ? h(Object(i), true).forEach(function(a) {
      w(t, a, i[a]);
    }) : Object.getOwnPropertyDescriptors ? Object.defineProperties(t, Object.getOwnPropertyDescriptors(i)) : h(Object(i)).forEach(function(a) {
      Object.defineProperty(t, a, Object.getOwnPropertyDescriptor(i, a));
    });
  }
  return t;
})({ name: "CountTo", emits: ["callback", "mountedCallback"] }, n);
export {
  F as C
};
