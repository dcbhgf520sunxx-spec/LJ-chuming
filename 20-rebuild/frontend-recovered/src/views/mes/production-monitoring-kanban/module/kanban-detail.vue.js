import { ref as H } from "vue";
import { inject as z } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as R } from "vue";
import { createBlock as T } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as g } from "vue";
import { toDisplayString as n } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as q } from "vue";
import { unref as m } from "vue";
import { withModifiers as E } from "vue";
import { isRef as P } from "vue";
import { ElTag as Q } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { a as A } from "../../../../modules/kanban-603b7875.js";
import { _ as K, u as O, o as S } from "../../../../shared/runtime.js";
const U = { style: { display: "flex" } }, F = { style: { width: "300px" } }, G = { __name: "kanban-detail", props: { visible: { type: Boolean, default: false }, detailList: { type: Object, default: () => {
} }, workshopId: { type: Number } }, emits: ["update:visible", "success"], setup(r, { emit: L }) {
  const w = H([]), j = L, i = r, C = z("permission"), { visible: u, handleClose: v } = O({ emit: j, props: i, field: "visible", showHook: N }), { maxHeight: D } = S({ mainBox: ".production-detail-dialog", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, u);
  async function N() {
    var b, s, d, f, _, o;
    try {
      const { content: p } = await A({ projectId: (s = (b = i.detailList) == null ? void 0 : b.project) == null ? void 0 : s.id, monomerId: (f = (d = i.detailList) == null ? void 0 : d.monomer) == null ? void 0 : f.id, areaId: (o = (_ = i.detailList) == null ? void 0 : _.area) == null ? void 0 : o.id, workshopId: i.workshopId });
      w.value = p || [];
    } catch (p) {
      console.log("获取零件清单明细失败", p);
    }
  }
  return (b, s) => {
    const d = Q, f = h("print-table"), _ = h("common-button"), o = W, p = h("common-table"), V = h("common-dialog"), B = M("permission");
    return R(), T(V, { title: "生产监控看板详情", customClass: "production-detail-dialog", modelValue: m(u), "onUpdate:modelValue": s[0] || (s[0] = (t) => P(u) ? u.value = t : null), "close-on-click-modal": false, width: "1500px", top: "5vh", showClose: false, "before-close": m(v) }, { titleAfter: l(() => [e(d, { size: "default" }, { default: l(() => {
      var t, a;
      return [g("项目：" + n((t = r.detailList.project) == null ? void 0 : t.contractNo) + "-" + n((a = r.detailList.project) == null ? void 0 : a.name), 1)];
    }), _: 1 }), e(d, { size: "default", style: { "margin-left": "8px" } }, { default: l(() => [g("排产总量（件/kg）：" + n(r.detailList.taskQuantity) + "/" + n(r.detailList.taskNetWeight), 1)]), _: 1 })]), titleRight: l(() => {
      var t, a, y, k, x, I;
      return [c("div", U, [c("div", F, [q(e(f, { "api-key": "mesProductionKanbanList", params: { projectId: (a = (t = i.detailList) == null ? void 0 : t.project) == null ? void 0 : a.id, monomerId: (k = (y = i.detailList) == null ? void 0 : y.monomer) == null ? void 0 : k.id, areaId: (I = (x = i.detailList) == null ? void 0 : x.area) == null ? void 0 : I.id, workshopId: i.workshopId }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[B, m(C).print]])]), e(_, { size: "default", type: "plain", class: "filter-item", style: { "margin-left": "8px" }, onClick: E(m(v), ["stop"]) }, { default: l(() => s[1] || (s[1] = [g(" 关闭 ")])), _: 1, __: [1] }, 8, ["onClick"])])];
    }), default: l(() => [e(p, { data: w.value, "max-height": m(D), "show-empty-symbol": false, style: { width: "100%" } }, { default: l(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", align: "center" }, { default: l(({ row: t }) => {
      var a;
      return [c("span", null, n(t.monomer ? (a = t.monomer) == null ? void 0 : a.name : "/"), 1)];
    }), _: 1 }), e(o, { prop: "area.name", "show-overflow-tooltip": true, label: "区域", align: "center" }, { default: l(({ row: t }) => {
      var a;
      return [c("span", null, n(t.area ? (a = t.area) == null ? void 0 : a.name : "/"), 1)];
    }), _: 1 }), e(o, { prop: "name", "show-overflow-tooltip": true, label: "名称", align: "center" }), e(o, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", align: "center" }), e(o, { prop: "specification", "show-overflow-tooltip": true, label: "规格", align: "center" }), e(o, { prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", align: "center" }), e(o, { prop: "material", "show-overflow-tooltip": true, label: "材质", align: "center" }, { default: l(({ row: t }) => [c("span", null, n(t.material), 1)]), _: 1 }), e(o, { prop: "quantity", "show-overflow-tooltip": true, label: "排产量", align: "center" }), e(o, { prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总重（kg）", align: "center" }), e(o, { prop: "completeQuantity", "show-overflow-tooltip": true, label: "实际完成数", align: "center" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Z = K(G, [["__scopeId", "data-v-db511ad9"]]);
export {
  Z as default
};
