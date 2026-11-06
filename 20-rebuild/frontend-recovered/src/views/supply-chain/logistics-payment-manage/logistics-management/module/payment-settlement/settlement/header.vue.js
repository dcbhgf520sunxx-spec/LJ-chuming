import { useStore as J } from "vuex";
import { computed as _ } from "vue";
import { inject as K } from "vue";
import { watch as y } from "vue";
import { ref as M } from "vue";
import { reactive as f } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as n } from "vue";
import { withCtx as r } from "vue";
import { unref as o } from "vue";
import { Fragment as k } from "vue";
import { renderList as E } from "vue";
import { createBlock as h } from "vue";
import { withDirectives as X } from "vue";
import { createTextVNode as Y } from "vue";
import { toDisplayString as Z } from "vue";
import { ElDatePicker as ee } from "element-plus";
import { ElOption as ae } from "element-plus";
import { ElSelect as te } from "element-plus";
import { ElInput as le } from "element-plus";
import { nextTick as P } from "vue";
import { c as oe, d as se } from "../../../../../../../modules/data-2d709dfa.js";
import { c as re } from "../../../../../../../modules/payment-settlement-a7865af1.js";
import { uD as ne, e3 as ce, dp as ie, cy as de, e5 as ue, b as w, e2 as pe, ec as j, e6 as x } from "../../../../../../../shared/runtime.js";
import { u as me } from "../../../../../../../modules/hook-467b8301.js";
const _e = { class: "header-container" }, fe = { key: 0, class: "notSlotValue truncate" }, Ie = { __name: "header", setup(he, { expose: L }) {
  const N = J(), O = _(() => N.getters.user.id), U = K("settlement_data"), { formData: t, projectInfo: u, tableList: p, contractListInfo: v } = U, C = _(() => ne(ce(se, u)));
  y(() => O.value, (e) => {
    t.userId = e;
  }, { immediate: true });
  const { supplierList: B, contractNoList: m, getSupplierList: A, getPurchaseContractNumber: R } = me({ form: t });
  A();
  const b = M([]), T = _(() => b.value.reduce((e, c) => (c.invoiceAmount && (e += c.invoiceAmount), e), 0)), g = f({ sum: 0, total: 0 });
  y(() => T.value, (e) => {
    g.sum = e;
  });
  const V = f({ total: 0 }), F = f({ pageSize: 10, pageNumber: 1 }), q = async () => {
    try {
      const e = await re({ orderId: t.orderId, ...F });
      if (!e.supplierSettlementEchoDtoPageVO) return pe("warning", "该合同号暂无付款及开票记录");
      b.value = e.supplierSettlementEchoDtoPageVO ? [...e.supplierSettlementEchoDtoPageVO] : [], await P(), V.total = e == null ? void 0 : e.totalElements;
      const c = j(e == null ? void 0 : e.supplierSettlementEchoDtoPageVO);
      p.splice(0), p.push(...c), await P(), e == null || delete e.supplierSettlementEchoDtoPageVO;
      const i = j([e]);
      Object.assign(v, ...i), Object.assign(u, ...i);
    } catch (e) {
      console.log(e);
    }
  }, D = () => {
    x(u), x(v), p.splice(0);
  }, H = () => {
    D(), t.orderId = null, m.value = [], w(t.supplierId) || R();
  }, z = async () => {
    D(), w(t.orderId) || await q();
  };
  return L({ recordInfo: V, invoiceInfo: g }), (e, c) => {
    const i = ee, I = ae, S = te, Q = le, $ = W("ellipsis");
    return s(), d("div", _e, [n(ie, { "header-title": "基本信息" }), n(ue, { column: 2, "form-data": o(t), "form-rules": o(oe), "table-list": C.value }, { createTime: r(({ item: l }) => [n(i, { modelValue: o(t)[l], "onUpdate:modelValue": (a) => o(t)[l] = a, clearable: "", placeholder: "请选择创建日期", type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), userId: r(({ item: l }) => [n(de, { modelValue: o(t)[l], "onUpdate:modelValue": (a) => o(t)[l] = a, clearable: false, filterable: "", placeholder: "选择创建人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), supplierId: r(({ item: l }) => [n(S, { modelValue: o(t)[l], "onUpdate:modelValue": (a) => o(t)[l] = a, clearable: "", filterable: "", placeholder: "请输入或选择供应商", onChange: H }, { default: r(() => [(s(true), d(k, null, E(o(B), (a) => (s(), h(I, { key: a.id, label: a.value, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), orderId: r(({ item: l }) => [n(S, { modelValue: o(t)[l], "onUpdate:modelValue": (a) => o(t)[l] = a, disabled: !o(m).length, clearable: "", filterable: "", placeholder: "请输入或选择采购合同号", onChange: z }, { default: r(() => [(s(true), d(k, null, E(o(m), (a) => (s(), h(I, { key: a.id, label: a.name, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), projectName: r(({ val: l, label: a }) => [l ? X((s(), d("div", fe, [Y(Z(l.split("/").filter(Boolean).map((G) => `【${G}】`).join(" ")), 1)])), [[$]]) : (s(), h(Q, { key: 1, placeholder: a, readonly: "" }, null, 8, ["placeholder"]))]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  Ie as default
};
