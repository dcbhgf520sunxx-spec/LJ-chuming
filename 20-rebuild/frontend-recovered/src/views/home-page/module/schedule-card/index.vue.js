import { ref as v } from "vue";
import { onMounted as j } from "vue";
import z from "moment";
import { resolveComponent as R } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as i } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as u } from "vue";
import { toDisplayString as f } from "vue";
import { Fragment as D } from "vue";
import { renderList as k } from "vue";
import { normalizeStyle as U } from "vue";
import { withCtx as C } from "vue";
import { unref as q } from "vue";
import { ElNotification as G } from "element-plus";
import { Calendar as J } from "@element-plus/icons-vue";
import { ElIcon as K } from "element-plus";
import { ElPopconfirm as Q } from "element-plus";
import { ElScrollbar as X } from "element-plus";
import { _ as Z, O as ee, a as ae } from "../../../../shared/runtime.js";
import { u as ne, _ as te, d as se } from "./schedule-dialog.vue.js";
const oe = { class: "card-content" }, le = { class: "calender-title" }, ce = { class: "calender-content" }, ue = { class: "weeks" }, re = { class: "days-box" }, ie = { class: "days" }, de = ["onClick"], ve = { class: "schedule" }, _e = { class: "schedule-title" }, he = { key: 0, class: "schedule-content" }, fe = { class: "item-right" }, pe = { key: 1, class: "schedule-no-data" }, me = { __name: "index", setup(ye) {
  const E = v(["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]), t = v((/* @__PURE__ */ new Date()).getFullYear()), n = v((/* @__PURE__ */ new Date()).getMonth() + 1), h = v((/* @__PURE__ */ new Date()).getDate()), b = v(), d = v([]), m = v(false), y = v([]);
  j(() => {
    x({ year: t.value, month: n.value }), B();
  });
  const { nowMonthList: T, fetchScheduleData: V } = ne();
  function B() {
    const s = { startTime: (/* @__PURE__ */ new Date()).getTime() };
    S(s);
  }
  async function S(s) {
    try {
      await V({ params: s }), d.value.forEach((e) => {
        T.value.forEach((c) => {
          e.day === c.day && (c.timeStr = z(c.setTime).format("YYYY-MM-DD HH:mm"), e.schedules.push(c));
        });
      }), M(h.value);
    } catch (e) {
      console.log(e);
    }
  }
  function x({ year: s, month: e }) {
    d.value = [], b.value = 32 - new Date(s, e - 1, 32).getDate();
    const c = new Date(s, e - 1, 1).getDay();
    for (let o = 1; o <= b.value; o++) {
      const w = { day: o, schedules: [] };
      d.value.push(w);
    }
    if (c - 1 > 0) for (let o = 0; o < c - 1; o++) d.value.unshift({ day: "", schedules: [] });
    else if (c - 1 === -1) for (let o = 0; o < 6; o++) d.value.unshift({ day: "", schedules: [] });
  }
  function L() {
    t.value = t.value - 1, _();
  }
  function A() {
    t.value = t.value + 1, _();
  }
  function F() {
    n.value === 1 ? (n.value = 12, t.value = t.value - 1) : n.value = n.value - 1, _();
  }
  function N() {
    n.value < 12 && n.value > 0 ? n.value = n.value + 1 : n.value === 12 && (n.value = 1, t.value = t.value + 1), _();
  }
  function M(s) {
    h.value = s, d.value.forEach((e) => {
      e.day === s && (y.value = e.schedules);
    });
  }
  function H() {
    t.value = (/* @__PURE__ */ new Date()).getFullYear(), n.value = (/* @__PURE__ */ new Date()).getMonth() + 1, h.value = (/* @__PURE__ */ new Date()).getDate(), _();
  }
  function I() {
    m.value = true;
  }
  function _() {
    const s = { startTime: new Date(t.value, n.value - 1, 1).getTime() };
    x({ year: t.value, month: n.value }), S(s);
  }
  const $ = ee(async function(s) {
    try {
      await se({ id: s }), G({ title: "删除日程成功", type: "success", duration: 2500 }), _();
    } catch (e) {
      console.log("删除行程失败", e);
    }
  }, 200, false);
  return (s, e) => {
    var Y;
    const c = R("common-button"), o = ae, w = J, O = K, P = Q, W = X;
    return r(), i("div", oe, [a("div", le, [u(c, { icon: "el-icon-circle-plus", class: "add-btn", onClick: I }), a("span", { class: "change-arrow", onClick: L }, [u(o, { "icon-class": "twoLeftArrow" })]), a("span", { class: "change-arrow", onClick: F }, [u(o, { "icon-class": "leftArrow", style: { margin: "0 20px" } })]), a("span", { style: { cursor: "pointer" }, onClick: H }, f(t.value) + "年 " + f(n.value) + "月", 1), a("span", { class: "change-arrow", onClick: N }, [u(o, { "icon-class": "rightArrow", style: { margin: "0 20px" } })]), a("span", { class: "change-arrow", onClick: A }, [u(o, { "icon-class": "twoRightArrow" })])]), a("div", ce, [a("ul", ue, [(r(true), i(D, null, k(E.value, (l, p) => (r(), i("li", { key: p }, f(l), 1))), 128))]), a("div", re, [a("ul", ie, [(r(true), i(D, null, k(d.value, (l, p) => {
      var g;
      return r(), i("li", { key: p }, [a("span", { class: "day-lable", style: U({ border: ((g = l.schedules) == null ? void 0 : g.length) > 0 ? "1px solid #3591B9" : "none", backgroundColor: h.value === l.day ? "#3591B9" : "#fff", color: h.value === l.day ? "#fff" : "#000" }), onClick: (we) => M(l.day) }, f(l.day), 13, de)]);
    }), 128))])])]), a("div", ve, [a("div", _e, [u(O, null, { default: C(() => [u(w)]), _: 1 }), e[1] || (e[1] = a("span", null, "日程", -1))]), (Y = y.value) != null && Y.length ? (r(), i("div", he, [u(W, { height: Math.ceil(d.value.length / 7) === 6 ? "105px" : "140px" }, { default: C(() => [(r(true), i(D, null, k(y.value, (l, p) => (r(), i("div", { key: p, class: "schedule-item" }, [a("div", null, [a("span", null, f(l.title), 1)]), a("div", fe, [a("span", null, f(l.timeStr), 1), u(P, { title: "确定要删除此日程吗？", onConfirm: (g) => q($)(l.id) }, { reference: C(() => e[2] || (e[2] = [a("span", { class: "del-btn" }, "删除", -1)])), _: 2 }, 1032, ["onConfirm"])])]))), 128))]), _: 1 }, 8, ["height"])])) : (r(), i("div", pe, e[3] || (e[3] = [a("span", null, "暂无数据", -1)])))]), u(te, { modelValue: m.value, "onUpdate:modelValue": e[0] || (e[0] = (l) => m.value = l), nowDate: t.value + "-" + n.value + "-" + h.value, onCreateSuccess: _ }, null, 8, ["modelValue", "nowDate"])]);
  };
} }, be = Z(me, [["__scopeId", "data-v-a69a0955"]]);
export {
  be as default
};
