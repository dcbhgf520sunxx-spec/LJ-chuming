import { ref as c } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as k } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as l } from "vue";
import { withCtx as n } from "vue";
import { unref as _ } from "vue";
import { createTextVNode as y } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as q } from "vue";
import { toDisplayString as s } from "vue";
import { isRef as F } from "vue";
import { Fragment as O } from "vue";
import { ElTableColumn as T } from "element-plus";
import { ElPagination as $ } from "element-plus";
import { vLoading as G } from "element-plus";
import { _ as M, u as A } from "../../../../../shared/runtime.js";
import J from "./detail.vue.js";
import { g as K } from "../../../../../modules/project-data-5e9d497a.js";
import "../../../../../modules/cutting-457c256f.js";
const Q = { class: "flex-rss" }, W = { __name: "steel-plate-list", props: { visible: { type: Boolean, required: true }, detailData: { type: Object } }, emits: ["update:visible"], setup(C, { emit: z }) {
  const u = C, o = { size: 20, page: 1, total: null }, p = c(false), x = z, { visible: d, handleClose: w } = A({ emit: x, props: u, field: "visible", closeHook: V, showHook: j }), v = c([]), m = c(false), I = c(), b = c([]);
  function j() {
    u.detailData && f();
  }
  function V() {
    o.size = 20, o.page = 1;
  }
  async function f() {
    p.value = true;
    try {
      const a = await K({ projectId: u.detailData.projectId, pageSize: o.size, pageNumber: o.page, mac: u.detailData.cutMachine.mac });
      o.total = a.totalElements, v.value = a.content;
    } catch (a) {
      console.log("钢板清单页面接口报错", a);
    }
    p.value = false;
  }
  function D(a) {
    b.value = a, m.value = true;
  }
  function N(a) {
    I.value = a.id;
  }
  function B(a) {
    o.size = a, f();
  }
  function S(a) {
    o.page = a, f();
  }
  return (a, t) => {
    const h = g("common-button"), i = T, E = g("common-table"), H = $, L = g("common-dialog"), R = G;
    return k(), U(O, null, [l(L, { title: "钢板切割状态", width: "70%", "show-close": false, "close-on-click-modal": false, modelValue: _(d), "onUpdate:modelValue": t[3] || (t[3] = (e) => F(d) ? d.value = e : null), "before-close": _(w) }, { titleRight: n(() => [l(h, { size: "default", onClick: _(w) }, { default: n(() => t[5] || (t[5] = [y("关 闭")])), _: 1, __: [5] }, 8, ["onClick"])]), default: n(() => [r("div", Q, [P((k(), q(E, { "row-key": "id", ref: "tableRef", "max-height": 500, style: { width: "100%" }, data: v.value }, { default: n(() => [l(i, { label: "序号", type: "index", align: "center", width: "60" }), l(i, { key: "cutInstructionId", prop: "cutInstructionId", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "100", align: "center" }, { default: n((e) => [r("span", null, s(e.row.cutInstructionId), 1)]), _: 1 }), l(i, { align: "center", key: "thick", prop: "thick", "show-overflow-tooltip": true, label: "厚度（mm）", "min-width": "55" }, { default: n((e) => [r("span", null, s(e.row.thick), 1)]), _: 1 }), l(i, { key: "material", align: "center", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "40" }, { default: n((e) => [r("span", null, s(e.row.material), 1)]), _: 1 }), l(i, { key: "specification", align: "center", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "40" }, { default: n((e) => [r("span", null, s(e.row.width) + " * " + s(e.row.length), 1)]), _: 1 }), l(i, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "55", align: "center" }, { default: n((e) => [r("span", null, s(e.row.projectNumber) + "-" + s(e.row.projectName), 1)]), _: 1 }), l(i, { align: "center", "show-overflow-tooltip": true, label: "套料成果", "min-width": "70" }, { default: n((e) => [l(h, { type: "success", size: "default", onClick: (X) => D(e.row) }, { default: n(() => t[6] || (t[6] = [y("查看")])), _: 2, __: [6] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data"])), [[R, p.value]])]), l(H, { "page-size": o.size, "onUpdate:pageSize": t[0] || (t[0] = (e) => o.size = e), "current-page": o.page, "onUpdate:currentPage": t[1] || (t[1] = (e) => o.page = e), total: o.total, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t[2] || (t[2] = (e) => B(e)), onCurrentChange: S }, null, 8, ["page-size", "current-page", "total"])]), _: 1 }, 8, ["modelValue", "before-close"]), l(J, { onChange: N, "detail-data": b.value, visible: m.value, "onUpdate:visible": t[4] || (t[4] = (e) => m.value = e) }, null, 8, ["detail-data", "visible"])], 64);
  };
} }, oe = M(W, [["__scopeId", "data-v-9e583360"]]);
export {
  oe as default
};
