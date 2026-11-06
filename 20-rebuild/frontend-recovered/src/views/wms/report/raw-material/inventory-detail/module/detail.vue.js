import { ref as x } from "vue";
import { inject as q } from "vue";
import { computed as R } from "vue";
import { watch as G } from "vue";
import { resolveComponent as B } from "vue";
import { resolveDirective as C } from "vue";
import { openBlock as r } from "vue";
import { createBlock as m } from "vue";
import { withCtx as n } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as v } from "vue";
import { withDirectives as b } from "vue";
import { createTextVNode as g } from "vue";
import { toDisplayString as j } from "vue";
import { createCommentVNode as p } from "vue";
import { unref as u } from "vue";
import { createElementBlock as V } from "vue";
import { Fragment as E } from "vue";
import { isRef as J } from "vue";
import { ElTag as W } from "element-plus";
import { ElTableColumn as X } from "element-plus";
import { vLoading as Z } from "element-plus";
import { l as k, t as ee, G as te, D, u as ae, o as ie, cO as ne, jl as oe, L as le, ux as re } from "../../../../../../shared/runtime.js";
function se(s) {
  return k({ module: "wms", url: "report/raw-materials/inventory-details", method: "get", params: s });
}
function O(s) {
  return k({ module: "wms", url: "report/raw-materials/inventory-details/detail", method: "get", params: s });
}
function ue(s) {
  return k({ module: "wms", url: "report/raw-materials/inventory-details/detail/excel", method: "get", responseType: "blob", params: s });
}
const pe = { get: se, detail: O }, de = { __name: "detail", props: { visible: { type: Boolean, default: false }, rowDetail: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(s, { emit: S }) {
  const { decimalPrecision: f } = ee(), U = x(), z = S, a = s, A = q("permission"), w = R(() => te(A.showAmount)), H = R(() => [["createTime", ["parse-time", "{y}-{m}-{d}"]], ["inboundUnitPriceExcludingVat", ["to-thousand", f.value.wms]], ["inboundAmountExcludingVat", ["to-thousand", D.YUAN]], ["outboundUnitPriceExcludingVat", ["to-thousand", f.value.wms]], ["outboundAmountExcludingVat", ["to-thousand", D.YUAN]], ["endUnitPriceExcludingVat", ["to-thousand", f.value.wms]], ["endAmountExcludingVat", ["to-thousand", D.YUAN]]]), { visible: y, handleClose: L } = ae({ emit: z, props: a, field: "visible" }), { maxHeight: F } = ie({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, extraHeight: 49, clientHRepMainH: true }, U);
  G(() => a.visible, (d) => {
    d && K();
  }, { immediate: true });
  const _ = x(false), P = x([]);
  async function K() {
    let d = [];
    try {
      _.value = true;
      const { content: i = [] } = await O({ times: a.rowDetail.times, detailKey: a.rowDetail.detailKey });
      await ne(i), d = await oe(i, { ...a.rowDetail.measure, basicClass: a.rowDetail.basicClass }, { mete: ["inboundMete", "outboundMete", "endMete"], quantity: ["inboundQuantity", "outboundQuantity", "endQuantity"], amount: ["inboundUnitPriceExcludingVat", "outboundUnitPriceExcludingVat", "endUnitPriceExcludingVat"] });
    } catch {
      console.log("获取存货明细账详情列表失败");
    } finally {
      P.value = d, _.value = false;
    }
  }
  return (d, i) => {
    const h = W, t = X, I = B("common-table"), Q = B("common-drawer"), T = C("parse-time"), Y = C("permission"), $ = Z;
    return r(), m(Q, { ref_key: "drawerRef", ref: U, title: "存货明细账详情", modelValue: u(y), "onUpdate:modelValue": i[0] || (i[0] = (l) => J(y) ? y.value = l : null), direction: "rtl", "close-on-click-modal": false, "before-close": u(L), size: "100%" }, { titleAfter: n(() => {
      var l;
      return [e(h, { effect: "plain", size: "large" }, { default: n(() => {
        var o, c, M, N;
        return [i[1] || (i[1] = v("span", null, "统计日期：", -1)), b(v("span", null, null, 512), [[T, { val: (c = (o = a.rowDetail) == null ? void 0 : o.times) == null ? void 0 : c[0], fmt: "{y}-{m}" }]]), i[2] || (i[2] = g(" ~ ")), b(v("span", null, null, 512), [[T, { val: (N = (M = a.rowDetail) == null ? void 0 : M.times) == null ? void 0 : N[1], fmt: "{y}-{m}" }]])];
      }), _: 1, __: [1, 2] }), (l = a.rowDetail) != null && l.project ? (r(), m(h, { key: 0, type: "success", effect: "plain", size: "large" }, { default: n(() => {
        var o, c;
        return [g(j((c = (o = a.rowDetail) == null ? void 0 : o.project) == null ? void 0 : c.name), 1)];
      }), _: 1 })) : p("", true), e(h, { type: "warning", effect: "plain", size: "large" }, { default: n(() => {
        var o;
        return [g("核算单位：" + j((o = a.rowDetail) == null ? void 0 : o.accountingUnit), 1)];
      }), _: 1 })];
    }), titleRight: n(() => {
      var l, o;
      return [b((r(), m(le, { params: { times: (l = a.rowDetail) == null ? void 0 : l.times, detailKey: (o = a.rowDetail) == null ? void 0 : o.detailKey }, fn: u(ue) }, { default: n(() => i[3] || (i[3] = [g("下载")])), _: 1, __: [3] }, 8, ["params", "fn"])), [[Y, u(A).download]])];
    }), content: n(() => [b((r(), m(I, { ref: "tableRef", data: P.value, "data-format": H.value, "show-empty-symbol": false, "max-height": u(F), style: { width: "100%" } }, { default: n(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { key: "createTime", prop: "createTime", label: "日期", align: "center", width: "100" }), e(t, { key: "receipt", "show-overflow-tooltip": true, prop: "receipt", label: "单据编号", align: "center", "min-width": "120" }, { default: n(({ row: l }) => [l.receipt ? (r(), m(u(re), { key: 0, "receipt-types": ["INBOUND", "OUTBOUND", "TRANSFER", "RETURN", "REJECTED"], receipt: l.receipt }, null, 8, ["receipt"])) : p("", true)]), _: 1 }), e(t, { key: "summary", prop: "summary", label: "摘要", "show-overflow-tooltip": true, "min-width": "120", align: "center" }), e(t, { key: "inboundData", prop: "inboundData", label: "入库数据", align: "center" }, { default: n(() => [e(t, { key: "inboundMete", prop: "inboundMete", align: "center", "min-width": "120", label: "数量" }), w.value ? (r(), V(E, { key: 0 }, [e(t, { key: "inboundUnitPriceExcludingVat", prop: "inboundUnitPriceExcludingVat", align: "right", "min-width": "120", label: "单价(不含税)" }), e(t, { key: "inboundAmountExcludingVat", prop: "inboundAmountExcludingVat", align: "right", "min-width": "120", label: "金额(不含税)" })], 64)) : p("", true)]), _: 1 }), e(t, { key: "outboundData", prop: "outboundData", label: "出库数据", align: "center" }, { default: n(() => [e(t, { key: "outboundMete", prop: "outboundMete", align: "center", "min-width": "120", label: "数量" }), w.value ? (r(), V(E, { key: 0 }, [e(t, { key: "outboundUnitPriceExcludingVat", prop: "outboundUnitPriceExcludingVat", align: "right", "min-width": "120", label: "单价(不含税)" }), e(t, { key: "outboundAmountExcludingVat", prop: "outboundAmountExcludingVat", align: "right", "min-width": "120", label: "金额(不含税)" })], 64)) : p("", true)]), _: 1 }), e(t, { key: "endData", prop: "endData", label: "结存数据", align: "center" }, { default: n(() => [e(t, { key: "endMete", prop: "endMete", align: "center", "min-width": "120", label: "数量" }), w.value ? (r(), V(E, { key: 0 }, [e(t, { key: "endUnitPriceExcludingVat", prop: "endUnitPriceExcludingVat", align: "right", "min-width": "120", label: "单价(不含税)" }), e(t, { key: "endAmountExcludingVat", prop: "endAmountExcludingVat", align: "right", "min-width": "120", label: "金额(不含税)" })], 64)) : p("", true)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[$, _.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, be = Object.freeze(Object.defineProperty({ __proto__: null, default: de }, Symbol.toStringTag, { value: "Module" }));
export {
  de as _,
  pe as c,
  be as d
};
