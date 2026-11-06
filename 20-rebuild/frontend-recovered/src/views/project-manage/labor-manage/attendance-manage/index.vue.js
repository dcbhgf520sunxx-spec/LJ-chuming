import { computed as h } from "vue";
import { ref as n } from "vue";
import k from "moment";
import { reactive as A } from "vue";
import { onMounted as L } from "vue";
import { watch as E } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as i } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as c } from "vue";
import { unref as u } from "vue";
import { createBlock as D } from "vue";
import { createTextVNode as U } from "vue";
import { createCommentVNode as Y } from "vue";
import { normalizeClass as F } from "vue";
import { ElDatePicker as J } from "element-plus";
import { ElCol as K } from "element-plus";
import { ElRow as Q } from "element-plus";
import { ElCalendar as W } from "element-plus";
import { g as X } from "../../../../modules/attendance-manage-750617cc.js";
import { x as m } from "../../../../modules/project-19a12d6b.js";
import { _ as Z, m as ee, p as w, i as z, G as b } from "../../../../shared/runtime.js";
import te from "./module/day-detail.vue.js";
import le from "./module/attendance-report.vue.js";
import oe from "./module/setting-dialog.vue.js";
import { _ as ae } from "../../../../modules/subcontract-supplier-select-bab9e7f8.js";
import "./component/day.vue.js";
import "./component/month.vue.js";
import "../../../../modules/index-df3c71c0.js";
const se = { class: "app-container" }, ne = { class: "head-container" }, ie = ["onClick"], re = { style: { color: "#000" } }, ue = { style: { color: "#529b2e" } }, pe = { style: { color: "#f56c6c" } }, me = { __name: "index", setup(de) {
  const { globalProjectId: B, globalProject: ce } = ee(["globalProjectId", "globalProject"]), p = h(() => B.value), d = n(), g = n(/* @__PURE__ */ new Date()), v = h(() => w(g.value, "{y}-{m}")), $ = n(), C = n(false), I = n(false), x = n(false), M = n(), H = n(k().format("YYYY年MM月DD日 HH:mm:ss")), V = n(false), a = A({ map: {}, list: [] });
  L(() => {
    setInterval(() => {
      H.value = k().format("YYYY年MM月DD日 HH:mm:ss");
    }, 1e3);
  }), E([() => p.value, () => d.value], (o) => {
    N();
  }, { immediate: true }), E(() => v.value, (o, e) => {
    (z(o) && z(e) && w(o, "{y}-{m}") !== w(e, "{y}-{m}") || !e) && N();
  }, { immediate: true });
  function R() {
    a.list = [], a.map = {};
  }
  async function N() {
    var o;
    if (b(m.get) && p.value) try {
      C.value = true, R();
      const e = await X({ projectId: p.value, supplierId: d.value, monthDate: k(v.value).valueOf() });
      a.list = e || [], (o = a.list) == null || o.forEach((f) => {
        a.map[f.attendanceDate] = f;
      });
    } catch (e) {
      console.log(e);
    } finally {
      C.value = false;
    }
  }
  function S(o) {
    var e;
    b(m.detail) && (M.value = o.day, (e = a.map[o.day]) != null && e.totalNumber && (x.value = true, console.log(o, "data")));
  }
  return (o, e) => {
    const f = J, P = O("common-button"), j = K, T = Q, G = W;
    return y(), q("div", se, [l("div", ne, [i(f, { modelValue: g.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => g.value = t), type: "month", size: "default", class: "filter-item", placeholder: "选择月", clearable: false, "value-format": "x", format: "YYYY-MM", style: { width: "150px", "margin-right": "8px" } }, null, 8, ["modelValue"]), i(ae, { class: "filter-item", modelValue: d.value, "onUpdate:modelValue": e[1] || (e[1] = (t) => d.value = t), projectId: p.value, clearable: "", style: { width: "270px" } }, null, 8, ["modelValue", "projectId"])]), i(G, { ref_key: "calendarRef", ref: $, modelValue: v.value, "onUpdate:modelValue": e[4] || (e[4] = (t) => v.value = t) }, { header: r(({ date: t }) => [l("span", null, c(t), 1), l("div", null, [u(b)(u(m).setting) ? (y(), D(P, { key: 0, type: "warning", size: "default", style: { "margin-right": "8px" }, class: "filter-item", icon: "el-icon-setting", onClick: e[2] || (e[2] = (_) => I.value = true) }, { default: r(() => e[8] || (e[8] = [U(" 考勤设置 ")])), _: 1, __: [8] })) : Y("", true), u(b)(u(m).attendanceReport) ? (y(), D(P, { key: 1, type: "primary", size: "default", class: "filter-item", onClick: e[3] || (e[3] = (_) => V.value = true) }, { default: r(() => e[9] || (e[9] = [U(" 考勤表 ")])), _: 1, __: [9] })) : Y("", true)])]), "date-cell": r(({ data: t }) => {
      var _;
      return [l("div", { style: "height: 100%;padding: 4px;", onClick: (s) => S(t) }, [l("div", { class: F(t.isSelected ? "is-selected" : "") }, c(t.day.split("-").slice(1).join("-")), 3), (_ = a.map[t.day]) != null && _.totalNumber ? (y(), D(T, { key: 0, style: { "margin-left": "40px", "font-size": "14px", "font-weight": "600" } }, { default: r(() => [i(j, { span: 24 }, { default: r(() => {
        var s;
        return [l("div", re, "应到：" + c(((s = a.map[t.day]) == null ? void 0 : s.totalNumber) || 0), 1)];
      }), _: 2 }, 1024), i(j, { span: 24 }, { default: r(() => {
        var s;
        return [l("div", null, [e[10] || (e[10] = l("span", { style: { color: "#000" } }, "实到：", -1)), l("span", ue, c(((s = a.map[t.day]) == null ? void 0 : s.clockNumber) || 0), 1)])];
      }), _: 2 }, 1024), i(j, { span: 24 }, { default: r(() => {
        var s;
        return [l("div", null, [e[11] || (e[11] = l("span", { style: { color: "#000" } }, "缺勤：", -1)), l("span", pe, c(((s = a.map[t.day]) == null ? void 0 : s.absenteeNumber) || 0), 1)])];
      }), _: 2 }, 1024)]), _: 2 }, 1024)) : Y("", true)], 8, ie)];
    }), _: 1 }, 8, ["modelValue"]), i(te, { visible: x.value, "onUpdate:visible": e[5] || (e[5] = (t) => x.value = t), currentDay: M.value, projectId: p.value, supplierId: d.value, permission: u(m) }, null, 8, ["visible", "currentDay", "projectId", "supplierId", "permission"]), i(le, { visible: V.value, "onUpdate:visible": e[6] || (e[6] = (t) => V.value = t), projectId: p.value, supplierId: d.value, permission: u(m) }, null, 8, ["visible", "projectId", "supplierId", "permission"]), i(u(oe), { visible: I.value, "onUpdate:visible": e[7] || (e[7] = (t) => I.value = t), projectId: p.value, permission: u(m) }, null, 8, ["visible", "projectId", "permission"])]);
  };
} }, we = Z(me, [["__scopeId", "data-v-63ada61e"]]);
export {
  we as default
};
