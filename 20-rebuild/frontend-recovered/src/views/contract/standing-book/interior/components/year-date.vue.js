import I from "moment";
import { resolveDirective as x } from "vue";
import { withDirectives as v } from "vue";
import { openBlock as d } from "vue";
import { createBlock as P } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as c } from "vue";
import { vModelText as w } from "vue";
import { toDisplayString as h } from "vue";
import { createElementBlock as Y } from "vue";
import { Fragment as k } from "vue";
import { renderList as m } from "vue";
import { normalizeClass as p } from "vue";
import { DArrowLeft as E } from "@element-plus/icons-vue";
import { ElIcon as V } from "element-plus";
import { DArrowRight as D } from "@element-plus/icons-vue";
import { Calendar as F } from "@element-plus/icons-vue";
import { ElPopover as N } from "element-plus";
import { _ as b } from "../../../../../shared/runtime.js";
const M = { bind(r, e, l) {
  function o(s) {
    if (r.contains(s.target)) return false;
    e && e.expression && e.value && e.value(s) && e.value(s);
  }
  r.__vueClickOutside__ = o, document.addEventListener("click", o);
}, unbind(r, e) {
  document.removeEventListener("click", r.__vueClickOutside__), delete r.__vueClickOutside__;
} }, i = { unselect: 0, selecting: 1, selected: 2 };
const H = { name: "YearPicker", directives: { clickoutside: M }, computed: { oneSelected() {
  return this.curState === i.selecting && (this.startYear === this.endYear || this.endYear == null);
}, leftYearList() {
  return this.yearList.slice(0, 10);
}, rightYearList() {
  return this.yearList.slice(10, 20);
} }, props: { sp: { default: "至" }, value: { default: null } }, data() {
  return { itemBg: {}, startShowYear: null, endShowYear: null, yearList: [], showPanel: false, startYear: null, endYear: null, curYear: 0, curSelectedYear: 0, curState: i.unselect };
}, methods: { handleInput(r) {
  switch (r) {
    case "start":
      if (isNaN(this.startShowYear)) {
        this.startShowYear = this.startYear;
        return;
      }
      this.startYear = this.startShowYear * 1;
      break;
    case "end":
      if (isNaN(this.endShowYear)) {
        this.endShowYear = this.endYear;
        return;
      }
      this.endYear = this.endShowYear * 1;
      break;
  }
  [this.startYear, this.endYear] = [this.endYear, this.startYear], this.startShowYear = this.startYear, this.endShowYear = this.endYear;
}, onHoverItem(r) {
  if (this.curState === i.selecting) {
    const e = this.curSelectedYear;
    this.endYear = Math.max(e, r), this.startYear = Math.min(e, r);
  }
}, async onClickItem(r) {
  var e, l, o, s, a, _;
  this.curState === i.unselect || this.curState === i.selected ? (this.startYear = r, this.curSelectedYear = r, this.endYear = null, this.curState = i.selecting) : this.curState === i.selecting && (this.endShowYear = this.endYear || this.startYear, this.startShowYear = this.startYear, this.curState = i.selected, await this.$nextTick(), this.showPanel = false, (_ = (s = (o = (l = (e = this.$parent) == null ? void 0 : e.$parent) == null ? void 0 : l.$parent) == null ? void 0 : o.$parent) == null ? void 0 : (a = s.$parent).clearValidate) == null || _.call(a));
}, async onFocus() {
  await this.$nextTick(), this.showPanel = true;
}, updateYearList() {
  const r = ~~(this.curYear / 10) * 10;
  this.yearList = [];
  for (let e = 0; e < 20; e++) this.yearList.push(r + e);
}, onClickLeft() {
  this.curYear = this.curYear * 1 - 10, this.updateYearList();
}, onClickRight() {
  this.curYear = this.curYear * 1 + 10, this.updateYearList();
} }, watch: { value: { handler(r) {
  if ((r == null ? void 0 : r.length) === 0) return;
  const [e, l] = r || [];
  this.startShowYear = e, this.endShowYear = l;
}, immediate: true, deep: true }, startShowYear: { handler(r) {
  this.$emit("input", [r, this.endShowYear || ""]);
}, immediate: true, deep: true }, endShowYear: { handler(r) {
  this.$emit("input", [this.startShowYear || "", r]);
}, immediate: true, deep: true } }, created() {
  const [r, e] = this.value || [];
  r ? (this.startYear = Number(r), this.endYear = Number(e), this.curState = i.selected, this.curYear = r) : this.curYear = I().format("yyyy"), this.updateYearList();
}, mounted() {
  window.Vue = this;
} }, T = { class: "_inner floatPanel" }, B = { class: "_inner leftPanel" }, R = { class: "_inner panelHead" }, U = { class: "_inner panelContent" }, A = ["onClick", "onMouseover"], O = { class: "_inner rightPanel" }, K = { class: "_inner panelHead" }, q = { class: "_inner panelContent" }, z = ["onClick", "onMouseover"], j = { ref: "yearPicker", class: "el-date-editor el-range-editor el-input__inner el-date-editor--daterange el-range-editor--default", style: { width: "240px" } }, G = { class: "el-range-separator", style: { width: "10%" } };
function J(r, e, l, o, s, a) {
  const _ = E, f = V, y = D, g = F, C = N, L = x("clickoutside");
  return v((d(), P(C, { ref: "popover", modelValue: s.showPanel, "onUpdate:modelValue": e[6] || (e[6] = (t) => s.showPanel = t), placement: "bottom", "popper-class": "custom_year_range" }, { reference: u(() => [n("div", j, [c(f, { class: "el-input__icon el-range__icon" }, { default: u(() => [c(g)]), _: 1 }), v(n("input", { ref: "inputLeft", "onUpdate:modelValue": e[0] || (e[0] = (t) => s.startShowYear = t), class: "_inner range_input", name: "yearInput", placeholder: "开始年份", type: "text", onFocus: e[1] || (e[1] = (...t) => a.onFocus && a.onFocus(...t)), onKeyup: e[2] || (e[2] = (t) => a.handleInput("start")) }, null, 544), [[w, s.startShowYear]]), n("span", G, h(l.sp), 1), v(n("input", { ref: "inputRight", "onUpdate:modelValue": e[3] || (e[3] = (t) => s.endShowYear = t), class: "_inner range_input", name: "yearInput", placeholder: "结束年份", type: "text", onFocus: e[4] || (e[4] = (...t) => a.onFocus && a.onFocus(...t)), onKeyup: e[5] || (e[5] = (t) => a.handleInput("end")) }, null, 544), [[w, s.endShowYear]])], 512)]), default: u(() => [n("div", T, [n("div", B, [n("div", R, [c(f, { class: "_inner", onClick: a.onClickLeft }, { default: u(() => [c(_)]), _: 1 }, 8, ["onClick"]), n("span", null, h(a.leftYearList[0] + "年 - " + a.leftYearList[9] + "年"), 1)]), n("div", U, [(d(true), Y(k, null, m(a.leftYearList, (t) => (d(), Y("div", { key: t, class: p({ oneSelected: t === s.startYear && a.oneSelected, startSelected: t === s.startYear, endSelected: t === s.endYear, betweenSelected: t > s.startYear && t < s.endYear }) }, [n("a", { class: p({ cell: true, _inner: true, selected: t === s.startYear || t === s.endYear }), onClick: (S) => a.onClickItem(t), onMouseover: (S) => a.onHoverItem(t) }, h(t), 43, A)], 2))), 128))])]), n("div", O, [n("div", K, [c(f, { class: "_inner", onClick: a.onClickRight }, { default: u(() => [c(y)]), _: 1 }, 8, ["onClick"]), n("span", null, h(a.rightYearList[0] + "年 - " + a.rightYearList[9] + "年"), 1)]), n("div", q, [(d(true), Y(k, null, m(a.rightYearList, (t) => (d(), Y("div", { key: t, class: p({ startSelected: t === s.startYear, endSelected: t === s.endYear, betweenSelected: t > s.startYear && t < s.endYear }) }, [n("a", { class: p({ cell: true, _inner: true, selected: t === s.endYear || t === s.startYear }), onClick: (S) => a.onClickItem(t), onMouseover: (S) => a.onHoverItem(t) }, h(t), 43, z)], 2))), 128))])])])]), _: 1 }, 8, ["modelValue"])), [[L, () => {
    s.showPanel = false;
  }]]);
}
const X = b(H, [["render", J], ["__scopeId", "data-v-6da4f5a1"]]);
export {
  X as default
};
