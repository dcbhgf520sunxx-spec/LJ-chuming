import { useStore as z } from "vuex";
import { computed as u } from "vue";
import { inject as $ } from "vue";
import { watch as D } from "vue";
import { ref as G } from "vue";
import { reactive as m } from "vue";
import { resolveComponent as J } from "vue";
import { resolveDirective as K } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as s } from "vue";
import { withCtx as n } from "vue";
import { unref as o } from "vue";
import { withDirectives as M } from "vue";
import { createTextVNode as Q } from "vue";
import { toDisplayString as W } from "vue";
import { createBlock as X } from "vue";
import { ElDatePicker as Y } from "element-plus";
import { ElInput as Z } from "element-plus";
import { nextTick as y } from "vue";
import { i as ee, j as te } from "../../../../../../modules/data-33e35578.js";
import { c as ae } from "../../../../../../modules/payment-settlement-a7865af1.js";
import { uD as oe, e3 as le, dp as se, cy as re, e5 as ne, b as S, e2 as ce, ec as k, e6 as E } from "../../../../../../shared/runtime.js";
import { u as ie } from "../../../../../../modules/hook-467b8301.js";
const de = { class: "header-container" }, pe = { key: 0, class: "notSlotValue truncate" }, ge = { __name: "header", setup(ue, { expose: P }) {
  const j = z(), w = u(() => j.getters.user.id), U = $("settlement_data"), { formData: t, projectInfo: i, tableList: d, contractListInfo: _ } = U, x = u(() => oe(le(te, i)));
  D(() => w.value, (e) => {
    t.userId = e;
  }, { immediate: true });
  const { supplierList: C, contractNoList: p, getSupplierList: N, getPurchaseContractNumber: L } = ie({ form: t });
  N();
  const f = G([]), O = u(() => f.value.reduce((e, r) => (r.invoiceAmount && (e += r.invoiceAmount), e), 0)), V = m({ sum: 0, total: 0 });
  D(() => O.value, (e) => {
    V.sum = e;
  });
  const g = m({ total: 0 }), B = m({ pageSize: 10, pageNumber: 1 }), A = async () => {
    try {
      const e = await ae({ orderId: t.orderId, ...B });
      if (!e.supplierSettlementEchoDtoPageVO) return ce("warning", "该合同号暂无付款及开票记录");
      f.value = e.supplierSettlementEchoDtoPageVO ? [...e.supplierSettlementEchoDtoPageVO] : [], await y(), g.total = e == null ? void 0 : e.totalElements;
      const r = k(e == null ? void 0 : e.supplierSettlementEchoDtoPageVO);
      d.splice(0), d.push(...r), await y(), e == null || delete e.supplierSettlementEchoDtoPageVO;
      const c = k([e]);
      Object.assign(_, ...c), Object.assign(i, ...c);
    } catch (e) {
      console.log(e);
    }
  }, v = () => {
    E(i), E(_), d.splice(0);
  }, T = () => {
    v(), t.orderId = null, p.value = [], S(t.supplierId) || L({ boolSettleUse: true });
  }, R = async () => {
    v(), S(t.orderId) || await A();
  };
  return P({ recordInfo: g, invoiceInfo: V }), (e, r) => {
    const c = Y, b = J("common-select-v2"), q = Z, F = K("ellipsis");
    return h(), I("div", de, [s(se, { "header-title": "基本信息" }), s(ne, { column: 2, "form-data": o(t), "form-rules": o(ee), "table-list": x.value }, { createTime: n(({ item: a }) => [s(c, { modelValue: o(t)[a], "onUpdate:modelValue": (l) => o(t)[a] = l, clearable: "", placeholder: "请选择创建日期", type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), userId: n(({ item: a }) => [s(re, { modelValue: o(t)[a], "onUpdate:modelValue": (l) => o(t)[a] = l, clearable: false, filterable: "", placeholder: "选择创建人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), supplierId: n(({ item: a }) => [s(b, { modelValue: o(t)[a], "onUpdate:modelValue": (l) => o(t)[a] = l, options: o(C), clearable: "", filterable: "", placeholder: "请输入或选择供应商", type: "other", onChange: T }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), orderId: n(({ item: a }) => [s(b, { modelValue: o(t)[a], "onUpdate:modelValue": (l) => o(t)[a] = l, disabled: !o(p).length, options: o(p), clearable: "", filterable: "", placeholder: "请输入或选择采购合同号", type: "other", onChange: R }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options"])]), projectName: n(({ val: a, label: l }) => [a ? M((h(), I("div", pe, [Q(W(a.split("/").filter(Boolean).map((H) => `【${H}】`).join(" ")), 1)])), [[F]]) : (h(), X(q, { key: 1, placeholder: l, readonly: "" }, null, 8, ["placeholder"]))]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  ge as default
};
