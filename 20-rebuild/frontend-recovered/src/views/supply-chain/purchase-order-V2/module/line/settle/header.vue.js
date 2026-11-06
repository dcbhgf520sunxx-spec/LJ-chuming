import { inject as V } from "vue";
import { computed as S } from "vue";
import { ref as y } from "vue";
import { reactive as p } from "vue";
import { watch as u } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as n } from "vue";
import { withCtx as i } from "vue";
import { unref as l } from "vue";
import { withDirectives as F } from "vue";
import { createTextVNode as $ } from "vue";
import { toDisplayString as G } from "vue";
import { createBlock as J } from "vue";
import { ElDatePicker as K } from "element-plus";
import { ElInput as M } from "element-plus";
import { nextTick as w } from "vue";
import { c as Q, d as W } from "../../../../../../modules/data-e85015ff.js";
import { c as X } from "../../../../../../modules/payment-settlement-a7865af1.js";
import { uD as Y, e3 as Z, i as f, dp as ee, cy as te, e5 as ae, b as _, e2 as oe, ec as E } from "../../../../../../shared/runtime.js";
import { u as le } from "../../../../../../modules/info-bbbe1651.js";
import "../../../../../../modules/payment-settlement-e8e799d8.js";
const re = { class: "header-container" }, se = { key: 0, class: "notSlotValue truncate" }, he = { __name: "header", setup(ne, { expose: N }) {
  const P = V("settlement_data"), { formData: t, projectInfo: h, tableList: v, contractListInfo: j } = P, x = S(() => Y(Z(W, h))), { supplierList: C, contractNoList: ie, getSupplierList: L, getContractNo: O } = le({ form: t });
  L();
  const g = y([]), A = S(() => g.value.reduce((e, r) => (r.invoiceAmount && (e += r.invoiceAmount), e), 0)), D = p({ sum: 0, total: 0 });
  u(() => A.value, (e) => {
    D.sum = e;
  });
  const I = p({ total: 0 }), B = p({ pageSize: 10, pageNumber: 1 }), b = y(false), U = async () => {
    try {
      const e = await X({ orderId: t.orderId, ...B });
      if (b.value = true, !e.supplierSettlementEchoDtoPageVO) return oe("warning", "该合同号暂无付款及开票记录");
      g.value = e.supplierSettlementEchoDtoPageVO ? [...e.supplierSettlementEchoDtoPageVO] : [], await w(), I.total = e == null ? void 0 : e.totalElements;
      const r = E(e == null ? void 0 : e.supplierSettlementEchoDtoPageVO);
      v.splice(0), v.push(...r), await w(), e == null || delete e.supplierSettlementEchoDtoPageVO;
      const s = E([e]);
      Object.assign(j, ...s), Object.assign(h, ...s);
    } catch (e) {
      console.log(e);
    }
  }, T = () => {
    _(t.supplierId) || O({ boolSettleUse: true });
  }, R = async () => {
    _(t.orderId) || await U();
  }, { item_data: c } = V("common");
  return u(() => c.value, (e) => {
    if (f(e)) {
      const { supplier: r, id: s } = e;
      t.supplierId = r.id, t.orderId = s;
    }
  }, { immediate: true, deep: true }), u(t, async () => {
    f(t.supplierId) && _(C.value) && await T(), f(t.orderId) && !b.value && await R();
  }, { immediate: true, deep: true }), N({ recordInfo: I, invoiceInfo: D }), (e, r) => {
    const s = K, d = M, q = z("ellipsis");
    return m(), k("div", re, [n(ee, { "header-title": "基本信息" }), n(ae, { column: 2, "form-data": l(t), "form-rules": l(Q), "table-list": x.value }, { createTime: i(({ item: a }) => [n(s, { modelValue: l(t)[a], "onUpdate:modelValue": (o) => l(t)[a] = o, clearable: "", placeholder: "请选择创建日期", type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), userId: i(({ item: a }) => [n(te, { modelValue: l(t)[a], "onUpdate:modelValue": (o) => l(t)[a] = o, clearable: true, filterable: "", placeholder: "选择创建人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), supplierId: i(() => {
      var a, o;
      return [n(d, { "model-value": (o = (a = l(c)) == null ? void 0 : a.supplier) == null ? void 0 : o.name, disabled: "" }, null, 8, ["model-value"])];
    }), orderId: i(() => {
      var a;
      return [n(d, { "model-value": (a = l(c)) == null ? void 0 : a.serialNumber, disabled: "" }, null, 8, ["model-value"])];
    }), projectName: i(({ val: a, label: o }) => [a ? F((m(), k("div", se, [$(G(a.split("/").filter(Boolean).map((H) => `【${H}】`).join(" ")), 1)])), [[q]]) : (m(), J(d, { key: 1, placeholder: o, readonly: "" }, null, 8, ["placeholder"]))]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  he as default
};
