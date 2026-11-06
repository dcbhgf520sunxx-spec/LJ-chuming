import { ref as B } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as V } from "vue";
import { createBlock as C } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { unref as m } from "vue";
import { createTextVNode as D } from "vue";
import { createElementVNode as l } from "vue";
import { toDisplayString as i } from "vue";
import { isRef as W } from "vue";
import { ElTableColumn as P } from "element-plus";
import { l as f, _ as S, u as M, ba as Q } from "../../../../../../shared/runtime.js";
function L(r) {
  return f({ url: "/api/cut/getMachinePartList", method: "get", params: r });
}
function _({ mac: r }) {
  return f({ url: `/api/cut/getPartListByMac/${r}`, method: "get" });
}
function O(r) {
  return f({ url: "/api/cut/exportByProject", method: "get", params: r });
}
const q = { get: L, exportByProject: O, getPartListByMac: _ };
const R = { class: "flex-rss" }, T = { __name: "index", props: { visible: { type: Boolean, required: true }, detailData: { type: Object } }, emits: ["update:visible"], setup(r, { emit: h }) {
  const u = r, b = h, { visible: p, handleClose: w } = M({ emit: b, props: u, field: "visible", closeHook: g, showHook: y }), c = B([]);
  function y() {
    u.detailData && v();
  }
  function g() {
  }
  async function v() {
    try {
      const n = await _(u.detailData);
      c.value = n, console.log(" plateData.value", c.value);
    } catch (n) {
      console.log("钢板清单页面接口报错", n);
    }
  }
  function k(n) {
    return Q(n, { props: ["producedQuantity", "totalNetWeight"] });
  }
  return (n, s) => {
    const N = d("common-button"), a = P, x = d("common-table"), j = d("common-dialog");
    return V(), C(j, { title: "零件详情", width: "70%", "show-close": false, "close-on-click-modal": false, modelValue: m(p), "onUpdate:modelValue": s[0] || (s[0] = (e) => W(p) ? p.value = e : null), "before-close": m(w) }, { titleRight: t(() => [o(N, { size: "default", onClick: m(w) }, { default: t(() => s[1] || (s[1] = [D("关 闭")])), _: 1, __: [1] }, 8, ["onClick"])]), default: t(() => [l("div", R, [o(x, { "summary-method": k, "show-summary": "", "row-key": "id", ref: "tableRef", "max-height": 500, style: { width: "100%" }, data: c.value }, { default: t(() => [o(a, { label: "序号", type: "index", align: "center", width: "60" }), o(a, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "55" }, { default: t((e) => [l("span", null, i(e.row.projectName), 1)]), _: 1 }), o(a, { key: "monomerName", prop: "monomerName", "show-overflow-tooltip": true, label: "单体", "min-width": "55" }, { default: t((e) => [l("span", null, i(e.row.monomerName), 1)]), _: 1 }), o(a, { key: "areaName", prop: "areaName", "show-overflow-tooltip": true, label: "单元", "min-width": "55" }, { default: t((e) => [l("span", null, i(e.row.areaName), 1)]), _: 1 }), o(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "55" }, { default: t((e) => [l("span", null, i(e.row.serialNumber), 1)]), _: 1 }), o(a, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "55" }, { default: t((e) => [l("span", null, i(e.row.specification), 1)]), _: 1 }), o(a, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "55" }, { default: t((e) => [l("span", null, i(e.row.material), 1)]), _: 1 }), o(a, { key: "producedQuantity", prop: "producedQuantity", "show-overflow-tooltip": true, label: "产量", "min-width": "55" }, { default: t((e) => [l("span", null, i(e.row.producedQuantity), 1)]), _: 1 }), o(a, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: "单重(kg)", "min-width": "55" }, { default: t((e) => [l("span", null, i(e.row.netWeight), 1)]), _: 1 }), o(a, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总重(kg)", "min-width": "55" }, { default: t((e) => [l("span", null, i(e.row.totalNetWeight), 1)]), _: 1 }), o(a, { key: "weight", prop: "weight", "show-overflow-tooltip": true, label: "完成日期", "min-width": "80" }, { default: t((e) => [l("span", null, i(e.row.weight), 1)]), _: 1 })]), _: 1 }, 8, ["data"])])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, z = S(T, [["__scopeId", "data-v-81d5f662"]]), A = Object.freeze(Object.defineProperty({ __proto__: null, default: z }, Symbol.toStringTag, { value: "Module" }));
export {
  q as c,
  z as d,
  A as i
};
