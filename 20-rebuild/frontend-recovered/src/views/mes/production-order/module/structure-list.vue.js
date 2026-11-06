import { ref as l } from "vue";
import { watch as D } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as d } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as v } from "vue";
import { withCtx as i } from "vue";
import { unref as o } from "vue";
import { toDisplayString as C } from "vue";
import { createCommentVNode as M } from "vue";
import { ElCol as P } from "element-plus";
import { ElRow as L } from "element-plus";
import { ElTableColumn as S } from "element-plus";
import { vLoading as F } from "element-plus";
import { a as W, b as j } from "../../../../modules/production-order-028b54f6.js";
import { _ as H, a3 as s, o as O, es as $, bV as G, D as K, i as U } from "../../../../shared/runtime.js";
import z from "./type-detail.vue.js";
import w from "./components/Panel/index.vue.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const J = { class: "artifact-tree-drawer-header" }, X = { style: { display: "flex", "margin-top": "15px" } }, Y = { style: { width: "45%", "padding-right": "10px" }, class: "tree-list" }, Z = { key: 0, style: { color: "red" } }, tt = { key: 1 }, et = { key: 0 }, at = { key: 1 }, ot = { style: { width: "54%", "padding-left": "10px" } }, rt = { key: 1, class: "my-code" }, nt = { __name: "structure-list", props: { currentId: { type: [String, Number], default: void 0 }, drawerVisible: { type: Boolean, require: true } }, setup(I) {
  const c = I, h = l([]), u = l(false), r = l(s.ARTIFACT.V), f = l({}), m = l({}), { maxHeight: N } = O({ extraBox: ".tag-div", wrapperBox: [".app-container", ".tree-list"] }), V = l([["artifactType", ["parse-enum", $]], ["auditReceiptTime", "parse-time"]]), A = l([s.ARTIFACT, s.ASSEMBLE, s.MACHINE_PART]);
  D(() => c.drawerVisible, (t) => {
    t && (r.value = s.ARTIFACT.V, f.value = {}, b(), q());
  }, { deep: true, immediate: true });
  async function q() {
    if (m.value = {}, !!c.currentId) {
      u.value = true;
      try {
        const t = await W({ projectId: c.currentId, productType: r.value });
        m.value = { artifactQuantity: [{ quantity: t.artifactQuantity || 0, unit: "件", precision: 0 }, { quantity: t.artifactMete || 0, unit: "kg", precision: 2 }], assembleQuantity: [{ quantity: t.assembleQuantity, unit: "件", precision: 0 }, { quantity: t.assembleMete, unit: "kg", precision: 2 }], machinePartQuantity: [{ quantity: t.machinePartQuantity, unit: "件", precision: 0 }, { quantity: t.machinePartMete, unit: "kg", precision: 2 }] };
      } catch (t) {
        console.log("获取构零件清单汇总失败", t);
      }
    }
  }
  async function b() {
    if (h.value = [], !!c.currentId) {
      u.value = true;
      try {
        const t = await j({ projectId: c.currentId, type: r.value });
        t.map((p) => {
          p.projectId = c.currentId;
        }), h.value = t || [], u.value = false;
      } catch (t) {
        console.log("获取构零件清单失败", t), u.value = false;
      }
    }
  }
  function R(t) {
    f.value = t;
  }
  return (t, p) => {
    const B = x("common-radio-button"), g = P, E = L, _ = S, Q = x("common-table"), T = F;
    return a(), d("div", null, [y("div", J, [e(B, { modelValue: r.value, "onUpdate:modelValue": p[0] || (p[0] = (n) => r.value = n), options: A.value, type: "enum", style: { "margin-bottom": "10px" }, onChange: b }, null, 8, ["modelValue", "options"]), k((a(), v(E, { gutter: 30, class: "panel-group" }, { default: i(() => [e(g, { span: 8, class: "card-panel-col" }, { default: i(() => [e(o(w), { name: "构件总数", "text-color": "#626262", "num-color": "#1890ff", "num-arr": m.value.artifactQuantity, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 }), e(g, { span: 8, class: "card-panel-col" }, { default: i(() => [e(o(w), { name: "部件总数", "text-color": "#626262", "num-color": "#1890ff", "num-arr": m.value.assembleQuantity, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 }), e(g, { span: 8, class: "card-panel-col" }, { default: i(() => [e(o(w), { name: "零件总数", "text-color": "#626262", "num-color": "#1890ff", "num-arr": m.value.machinePartQuantity, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 })]), _: 1 })), [[T, u.value]])]), y("div", X, [y("div", Y, [k((a(), v(Q, { data: h.value, onCurrentChange: R, "data-format": V.value, "highlight-current-row": "", "max-height": o(N) - 70 }, { default: i(() => [e(_, { key: "classificationName", prop: "classificationName", label: `${o(s).VL[r.value]}分类`, align: "center", "show-overflow-tooltip": true }, { default: i((n) => [n.row.classificationId === null ? (a(), d("span", Z, "未知类型")) : (a(), d("span", tt, C(n.row.classificationName), 1))]), _: 1 }, 8, ["label"]), r.value === o(s).ARTIFACT.V ? (a(), v(_, { key: "artifactType", prop: "artifactType", label: "构件类型", align: "center", "show-overflow-tooltip": true })) : M("", true), e(_, { key: "material", prop: "material", label: "材质", align: "center", "show-overflow-tooltip": true }), e(_, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true }), e(_, { key: "totalNetWeight", prop: "totalNetWeight", label: "重量（kg）", align: "center", "show-overflow-tooltip": true }, { default: i((n) => [n.row.totalNetWeight ? (a(), d("span", et, C(o(G)(n.row.totalNetWeight, o(K).COM_WT__KG)), 1)) : (a(), d("span", at, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[T, u.value]])]), p[1] || (p[1] = y("div", { style: { "border-right": "1px solid #ededed", height: "calc(100vh - 260px)" } }, null, -1)), y("div", ot, [o(U)(f.value) ? (a(), v(o(z), { key: 0, currentRow: f.value, productType: r.value }, null, 8, ["currentRow", "productType"])) : (a(), d("div", rt, "*点击左表操作查看明细"))])])]);
  };
} }, dt = H(nt, [["__scopeId", "data-v-d5307725"]]);
export {
  dt as default
};
