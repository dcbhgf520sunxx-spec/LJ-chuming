import { inject as k } from "vue";
import { reactive as v } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as E } from "vue";
import { createVNode as n } from "vue";
import { withCtx as u } from "vue";
import { unref as h } from "vue";
import { ElCheckbox as A } from "element-plus";
import { ElTableColumn as T } from "element-plus";
import { ElTable as D } from "element-plus";
import { _ as I, dp as P, eb as x, e7 as S, iY as V, ec as q } from "../../../../../../shared/runtime.js";
import { c as w } from "../../../../../../modules/payment-settlement-e8e799d8.js";
const N = { class: "second-container" }, j = { __name: "second-table", setup(z) {
  const { tableList: s, formData: i, headerRef: _ } = k("invoice_data");
  s.forEach((a) => {
    a.checked = false;
  });
  const f = (a, c) => {
    s.forEach((t) => {
      t === a ? t.checked ? (i.supplierPaymentId = a.supplierPaymentId, i.invoiceAmount = null, i.invoiceSerialNumber = null) : (t.checked = false, i.supplierPaymentId = null) : t.checked = false;
    });
  }, d = v({ pageSize: 10, pageNumber: 1 }), g = (a) => {
    if (a && a.columns.length && a.data.length) {
      const { columns: c, data: t } = a, e = [], r = ["paymentAmount", "invoiceAmount"];
      return c.forEach((l, o) => {
        if (o === 0) {
          e[o] = "合计";
          return;
        }
        r.includes(l.property) && t.forEach((p) => {
          if (p[l.property]) {
            const m = S(p[l.property]);
            e[o] ? e[o] += m : e[o] = m;
          }
        });
      }), V(e);
    }
  }, b = async (a = {}) => {
    try {
      const c = await w({ ...i, ...d }), t = q(c.list.content);
      s.splice(0, s.length, ...t);
    } catch (c) {
      console.log(c);
    }
  }, y = async () => {
    b();
  };
  return (a, c) => {
    const t = A, e = T, r = D;
    return C(), E("div", N, [n(P, { "header-title": "付款及发票记录" }), n(r, { "max-height": "340", border: "", fit: "", data: h(s), "show-summary": "", "summary-method": g }, { default: u(() => [n(e, { width: "60", align: "center" }, { default: u(({ row: l }) => [n(t, { modelValue: l.checked, "onUpdate:modelValue": (o) => l.checked = o, onChange: (o) => f(l, o), size: "large" }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }), n(e, { label: "序号", type: "index", align: "center", width: "80" }), n(e, { prop: "paymentAmount", label: "付款", align: "center", "min-width": "120" }), n(e, { prop: "paymentDate", label: "日期", align: "center", "min-width": "120" }), n(e, { prop: "invoiceAmount", label: "发票", align: "center", "min-width": "120" }), n(e, { prop: "invoiceDate", label: "日期", align: "center", "min-width": "120" })]), _: 1 }, 8, ["data"]), n(x, { "request-data": d, total: h(_).recordInfo.total, onHandleChange: y }, null, 8, ["request-data", "total"])]);
  };
} }, U = I(j, [["__scopeId", "data-v-6650b9f6"]]);
export {
  U as default
};
