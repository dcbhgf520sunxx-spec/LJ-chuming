import { ref as c } from "vue";
import { computed as Q } from "vue";
import { watch as Y } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as h } from "vue";
import { createBlock as b } from "vue";
import { withCtx as r } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as m } from "vue";
import { toDisplayString as u } from "vue";
import { withDirectives as x } from "vue";
import { createCommentVNode as J } from "vue";
import { unref as n } from "vue";
import { isRef as $ } from "vue";
import { ElTag as G } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElPagination as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { l as T, t as Z, u as ee, J as te, D as C, o as oe, ba as ae } from "../../../../../shared/runtime.js";
function le(s) {
  return T({ module: "enclosure", url: "produce/overview/order/team/produce", method: "get", params: s });
}
function L(s) {
  return T({ module: "enclosure", url: "produce/overview/order/team/produce/detail", method: "get", params: s });
}
const se = { get: le, detail: L }, re = { __name: "detail", props: { visible: { type: Boolean, default: false }, info: { type: Object }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(s, { emit: z }) {
  const { decimalPrecision: S } = Z(), N = z, t = s, { visible: d, handleClose: E } = ee({ emit: N, props: t, field: "visible" }), { handleSizeChange: A, handleCurrentChange: D, total: P, setTotalPage: j, queryPage: f } = te({ fetchHook: k }), g = c(false), v = c([]), w = c(), R = c([["reportTotalLength", ["to-fixed", C.MES_ENCLOSURE_L__M]], ["price", ["to-fixed-ck", "YUAN"]], ["totalAmount", ["to-fixed-ck", "YUAN"]]]), y = Q(() => {
    var o;
    return { endTime: t.info.endTime, startTime: t.info.startTime, projectId: t.info.projectId, lineId: (o = t.info.line) == null ? void 0 : o.id, teamId: t.info.teamId, price: t.info.price };
  });
  Y(() => t.visible, (o) => {
    o && k();
  }, { immediate: true });
  const { maxHeight: V } = oe({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, w);
  function M(o) {
    return ae(o, { props: [["totalAmount", S.value.enclosure], ["reportTotalLength", C.MES_ENCLOSURE_L__M]] });
  }
  async function k() {
    try {
      g.value = true;
      const { content: o, totalElements: p } = await L({ ...y.value, ...f });
      v.value = o.map((a) => (a.reportTotalLength = (a.reportTotalLength || 0) / 1e3, a.totalAmount = (a.price || 0) * a.reportTotalLength, a)), j(p);
    } catch (o) {
      console.log("获取班组产量详情", o);
    } finally {
      g.value = false;
    }
  }
  return (o, p) => {
    const a = G, I = _("print-table"), l = K, O = _("common-table"), B = W, H = _("common-drawer"), U = F("permission"), q = X;
    return h(), b(H, { ref_key: "drawerRef", ref: w, title: "班组产量详情", modelValue: n(d), "onUpdate:modelValue": p[0] || (p[0] = (i) => $(d) ? d.value = i : null), direction: "rtl", "before-close": n(E), size: "70%" }, { titleAfter: r(() => [e(a, { size: "large", effect: "plain" }, { default: r(() => [m(u(t.info.project), 1)]), _: 1 }), e(a, { size: "large", effect: "plain" }, { default: r(() => {
      var i;
      return [m(u((i = t.info.workshop) == null ? void 0 : i.name), 1)];
    }), _: 1 }), e(a, { size: "large", effect: "plain" }, { default: r(() => {
      var i;
      return [m(u((i = t.info.line) == null ? void 0 : i.name), 1)];
    }), _: 1 }), e(a, { size: "large", effect: "plain" }, { default: r(() => [m(u(t.info.LeaderName), 1)]), _: 1 })]), titleRight: r(() => [s.visible ? x((h(), b(I, { key: 0, params: y.value, "api-key": "enclosureTeamProductionDetail", size: "default", type: "warning" }, null, 8, ["params"])), [[U, t.permission.printDetail]]) : J("", true)]), content: r(() => [x((h(), b(O, { data: v.value, "max-height": n(V), "data-format": R.value, "show-summary": "", "summary-method": M }, { default: r(() => [e(l, { label: "序号", type: "index", align: "center", width: "60" }), e(l, { "show-overflow-tooltip": "", prop: "plan.name", key: "plan.name", label: "批次", align: "center" }), e(l, { "show-overflow-tooltip": "", prop: "name", key: "name", label: "名称", align: "center" }), e(l, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" }), e(l, { "show-overflow-tooltip": "", prop: "plate", key: "plate", label: "板型", align: "center" }), e(l, { "show-overflow-tooltip": "", prop: "brand", key: "brand", label: "品牌", align: "center" }), e(l, { "show-overflow-tooltip": "", prop: "color", key: "color", label: "颜色", align: "center" }), e(l, { "show-overflow-tooltip": "", prop: "reportQuantity", key: "reportQuantity", label: "数量", align: "center" }), e(l, { "show-overflow-tooltip": "", prop: "reportTotalLength", key: "reportTotalLength", label: "产量(m)", align: "center" }), e(l, { "show-overflow-tooltip": "", prop: "price", key: "price", label: "单价", align: "center" }), e(l, { "show-overflow-tooltip": "", prop: "totalAmount", key: "totalAmount", label: "总价", align: "center" })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[q, g.value]]), e(B, { total: n(P), "current-page": n(f).pageNumber, "page-size": n(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(A), onCurrentChange: n(D) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, pe = Object.freeze(Object.defineProperty({ __proto__: null, default: re }, Symbol.toStringTag, { value: "Module" }));
export {
  re as _,
  se as c,
  pe as d
};
