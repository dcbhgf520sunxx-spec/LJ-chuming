import { ref as p } from "vue";
import { watch as f } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as N } from "vue";
import { createBlock as V } from "vue";
import { withCtx as s } from "vue";
import { createCommentVNode as G } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as r } from "vue";
import { unref as v } from "vue";
import { toDisplayString as n } from "vue";
import { isRef as S } from "vue";
import { ElTableColumn as T } from "element-plus";
import { b as z } from "../../../../../modules/kanban-603b7875.js";
import { g as P } from "../../../../../modules/group-report-de628baf.js";
import { o as U, u as j } from "../../../../../shared/runtime.js";
import A from "./group-status-detail.vue.js";
const L = { style: { display: "flex" } }, O = { style: { width: "32%" } }, q = { class: "tc-success" }, J = { class: "tc-primary" }, K = { class: "tc-danger" }, Q = { style: { width: "67%" } }, te = { __name: "group-status-drawer", props: { visible: { type: Boolean, default: false }, groupDetailData: { type: Object, default: () => {
} }, workshopId: { type: Number } }, emits: ["update:visible"], setup(_, { emit: C }) {
  const D = C, u = p({}), c = p([]), y = p([]), l = p(), m = p({}), i = _, { maxHeight: W } = U({ mainBox: ".group-detail-drawer", extraBox: [".el-drawer__header", ".title"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }), { visible: h, handleClose: B } = j({ emit: D, props: i, field: "visible", showHook: M });
  function M() {
    u.value = {}, l.value = void 0, b(), w();
  }
  f(() => i.workshopId, (e) => {
    w();
  }, { immediate: true }), f(() => i.workshopId, (e) => {
    b();
  }), f(() => l.value, (e) => {
    e && (u.value = {}, w());
  });
  async function b() {
    try {
      const e = await P({ workshopId: i.workshopId });
      console.log(e, "data"), y.value = e || [], e == null || e.forEach((t) => {
        m[t.id] = t;
      }), console.log(m, "processMap");
    } catch {
      console.log("获取班组的工序失败");
    }
  }
  async function w() {
    var e;
    c.value = [];
    try {
      const t = await z({ workshopId: i.workshopId, processId: l.value, taskTypeEnum: (e = m[l.value]) == null ? void 0 : e.productType });
      c.value = t || [];
    } catch (t) {
      console.log("获取班组状态失败", t);
    }
  }
  function H(e) {
    u.value = e;
  }
  return (e, t) => {
    const R = g("common-radio-button"), d = T, E = g("common-table"), F = g("common-drawer");
    return N(), V(F, { ref: "drawerRef", customClass: "group-detail-drawer", title: "班组状态", modelValue: v(h), "onUpdate:modelValue": t[1] || (t[1] = (o) => S(h) ? h.value = o : null), direction: "rtl", "before-close": v(B), size: "100%" }, { titleAfter: s(() => [_.workshopId ? (N(), V(R, { key: 0, modelValue: l.value, "onUpdate:modelValue": t[0] || (t[0] = (o) => l.value = o), options: y.value, type: "other", class: "filter-item", default: "", dataStructure: { key: "id", label: "name", value: "id" }, size: "default" }, null, 8, ["modelValue", "options"])) : G("", true)]), content: s(() => [a("div", L, [a("div", O, [r(E, { ref: "directRef", "highlight-current-row": "", data: c.value, style: { width: "100%", cursor: "pointer" }, "row-key": "id", "max-height": v(W), onRowClick: H }, { default: s(() => [r(d, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), r(d, { "show-overflow-tooltip": true, prop: "groups.name", key: "groups.name", label: "产线/班组", align: "left", "min-width": "220" }, { default: s(({ row: o }) => {
      var k, x, I;
      return [a("span", null, n((k = o.productionLine) == null ? void 0 : k.name) + ">" + n((x = o.groups) == null ? void 0 : x.name) + ">" + n((I = o.team) == null ? void 0 : I.name), 1)];
    }), _: 1 }), r(d, { "show-overflow-tooltip": true, prop: "yearNetWeight", key: "yearNetWeight", label: `年度平均产量
（吨）`, align: "center", width: "110px" }, { default: s(({ row: o }) => [a("span", q, n((o.yearNetWeight / 1e3).toFixed(2)), 1)]), _: 1 }), r(d, { "show-overflow-tooltip": true, prop: "lastMonthNetWeight", key: "lastMonthNetWeight", label: `上月产量
（吨）`, align: "center", width: "90px" }, { default: s(({ row: o }) => [a("span", J, n((o.lastMonthNetWeight / 1e3).toFixed(2)), 1)]), _: 1 }), r(d, { "show-overflow-tooltip": true, prop: "unNetWeight", key: "unNetWeight", label: `在手任务
（吨）`, align: "center", width: "90px" }, { default: s(({ row: o }) => [a("span", K, n((o.unNetWeight / 1e3).toFixed(2)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), t[2] || (t[2] = a("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 180px)" } }, null, -1)), a("div", Q, [r(A, { "detail-data": u.value, workshopId: i.workshopId, processId: l.value }, null, 8, ["detail-data", "workshopId", "processId"])])])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  te as default
};
