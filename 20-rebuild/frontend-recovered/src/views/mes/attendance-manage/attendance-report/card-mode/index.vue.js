import { ref as d } from "vue";
import { computed as H } from "vue";
import b from "moment";
import { reactive as j } from "vue";
import { onMounted as O } from "vue";
import { watch as w } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as P } from "vue";
import { createElementVNode as t } from "vue";
import { createVNode as n } from "vue";
import { unref as M } from "vue";
import { createBlock as k } from "vue";
import { withCtx as o } from "vue";
import { toDisplayString as i } from "vue";
import { normalizeClass as $ } from "vue";
import { createTextVNode as E } from "vue";
import { createCommentVNode as B } from "vue";
import { ElDatePicker as G } from "element-plus";
import { ElTag as L } from "element-plus";
import { ElCol as W } from "element-plus";
import { ElRow as q } from "element-plus";
import { ElCalendar as F } from "element-plus";
import { g as J } from "../../../../../modules/attendance-report-ce8c4447.js";
import { _ as K, p as x, i as I, G as A, n2 as g, iW as Q, bE as X } from "../../../../../shared/runtime.js";
import Z from "./module/day-detail.vue.js";
const ee = { class: "head-container" }, le = { style: "padding: 4px;display:flex;" }, ae = { style: { color: "#000" } }, te = { style: { color: "#529b2e" } }, se = { style: { color: "#f56c6c" } }, oe = { style: { color: "#000" } }, ne = { style: { color: "#529b2e" } }, re = { style: { color: "#f56c6c" } }, ie = { __name: "index", setup(ue) {
  const m = d(), f = d(/* @__PURE__ */ new Date()), _ = H(() => x(f.value, "{y}-{m}")), R = d(), C = d(false), v = d(false), V = d(), S = d(b().format("YYYY年MM月DD日 HH:mm:ss")), s = j({ map: {}, list: [] });
  O(() => {
    setInterval(() => {
      S.value = b().format("YYYY年MM月DD日 HH:mm:ss");
    }, 1e3);
  }), w([() => m.value], () => {
    N();
  }, { immediate: true }), w(() => _.value, (r, e) => {
    (I(r) && I(e) && x(r, "{y}-{m}") !== x(e, "{y}-{m}") || !e) && N();
  }, { immediate: true });
  function U() {
    s.list = [], s.map = {};
  }
  async function N() {
    var r;
    if (A([...g.get])) try {
      C.value = true, U();
      const e = await J({ supplierId: m.value, monthDate: b(_.value).valueOf() });
      s.list = e || [], (r = s.list) == null || r.forEach((u) => {
        s.map[u.attendanceDate] = u;
      });
    } catch (e) {
      console.log(e);
    } finally {
      C.value = false;
    }
  }
  function D(r, e) {
    var u, c;
    A([...g.detail]) && (V.value = { data: r.day, isStand: e }, !(!((u = s.map[r.day]) != null && u.overTotalNumber) && !((c = s.map[r.day]) != null && c.standTotalNumber)) && (v.value = true));
  }
  return (r, e) => {
    const u = G, c = L, p = W, T = q, z = F;
    return y(), P("div", null, [t("div", null, [t("div", ee, [n(u, { modelValue: f.value, "onUpdate:modelValue": e[0] || (e[0] = (l) => f.value = l), type: "month", size: "default", placeholder: "选择月", clearable: false, "value-format": "x", format: "YYYY-MM", style: { width: "150px", "margin-right": "8px" } }, null, 8, ["modelValue"]), n(X, { modelValue: m.value, "onUpdate:modelValue": e[1] || (e[1] = (l) => m.value = l), showType: false, placeholder: "分包单位", basicClass: M(Q).LABOR_SUBCONTRACTING.V, clearable: "", style: { width: "270px" } }, null, 8, ["modelValue", "basicClass"])]), (y(), k(z, { ref_key: "calendarRef", ref: R, modelValue: _.value, "onUpdate:modelValue": e[2] || (e[2] = (l) => _.value = l), key: f.value }, { header: o(({ date: l }) => [t("span", null, i(l), 1)]), "date-cell": o(({ data: l }) => {
      var Y, h;
      return [t("div", { class: $(l.isSelected ? "is-selected" : "") }, i(l.day.split("-").slice(1).join("-")), 3), t("div", le, [(Y = s.map[l.day]) != null && Y.standTotalNumber ? (y(), k(T, { key: 0, style: { "font-size": "12px", "font-weight": "600", display: "flex", "margin-left": "20px" }, onClick: (a) => D(l, true) }, { default: o(() => [n(c, { type: "success", effect: "plain", round: "" }, { default: o(() => e[4] || (e[4] = [E(" 常规考勤 ")])), _: 1, __: [4] }), n(p, { span: 24 }, { default: o(() => {
        var a;
        return [t("div", ae, "应到：" + i(((a = s.map[l.day]) == null ? void 0 : a.standTotalNumber) || 0), 1)];
      }), _: 2 }, 1024), n(p, { span: 24 }, { default: o(() => {
        var a;
        return [t("div", null, [e[5] || (e[5] = t("span", { style: { color: "#000" } }, "实到：", -1)), t("span", te, i(((a = s.map[l.day]) == null ? void 0 : a.standClockNumber) || 0), 1)])];
      }), _: 2 }, 1024), n(p, { span: 24 }, { default: o(() => {
        var a;
        return [t("div", null, [e[6] || (e[6] = t("span", { style: { color: "#000" } }, "缺勤：", -1)), t("span", se, i(((a = s.map[l.day]) == null ? void 0 : a.standAbsenteeNumber) || 0), 1)])];
      }), _: 2 }, 1024)]), _: 2 }, 1032, ["onClick"])) : B("", true), (h = s.map[l.day]) != null && h.overTotalNumber ? (y(), k(T, { key: 1, style: { "font-size": "12px", "font-weight": "600", display: "flex" }, onClick: (a) => D(l, false) }, { default: o(() => [n(c, { type: "danger", effect: "plain", round: "" }, { default: o(() => e[7] || (e[7] = [E(" 加班考勤 ")])), _: 1, __: [7] }), n(p, { span: 24 }, { default: o(() => {
        var a;
        return [t("div", oe, "应到：" + i(((a = s.map[l.day]) == null ? void 0 : a.overTotalNumber) || 0), 1)];
      }), _: 2 }, 1024), n(p, { span: 24 }, { default: o(() => {
        var a;
        return [t("div", null, [e[8] || (e[8] = t("span", { style: { color: "#000" } }, "实到：", -1)), t("span", ne, i(((a = s.map[l.day]) == null ? void 0 : a.overClockNumber) || 0), 1)])];
      }), _: 2 }, 1024), n(p, { span: 24 }, { default: o(() => {
        var a;
        return [t("div", null, [e[9] || (e[9] = t("span", { style: { color: "#000" } }, "缺勤：", -1)), t("span", re, i(((a = s.map[l.day]) == null ? void 0 : a.overAbsenteeNumber) || 0), 1)])];
      }), _: 2 }, 1024)]), _: 2 }, 1032, ["onClick"])) : B("", true)])];
    }), _: 1 }, 8, ["modelValue"])), n(Z, { visible: v.value, "onUpdate:visible": e[3] || (e[3] = (l) => v.value = l), currentDay: V.value, supplierId: m.value, permission: M(g) }, null, 8, ["visible", "currentDay", "supplierId", "permission"])])]);
  };
} }, _e = K(ie, [["__scopeId", "data-v-f15d3fb8"]]);
export {
  _e as default
};
