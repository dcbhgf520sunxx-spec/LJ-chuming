import { inject as b } from "vue";
import { reactive as y } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as t } from "vue";
import { withCtx as A } from "vue";
import { unref as d } from "vue";
import { ElTableColumn as D } from "element-plus";
import { ElTable as E } from "element-plus";
import { dp as T, eb as C, e7 as q, iY as P, ec as S } from "../../../../../../../shared/runtime.js";
import { c as j } from "../../../../../../../modules/payment-settlement-e8e799d8.js";
const k = { class: "second-container" }, N = { __name: "second-table", setup(B) {
  const { tableList: r, formData: p, headerRef: u } = b("settlement_data"), h = (n) => {
    if (n && n.columns.length && n.data.length) {
      const { columns: o, data: e } = n, a = [], _ = ["paymentAmount", "invoiceAmount"];
      return o.forEach((c, s) => {
        if (s === 0) {
          a[s] = "合计";
          return;
        }
        _.includes(c.property) && e.forEach((i) => {
          if (i[c.property]) {
            const m = q(i[c.property]);
            a[s] ? a[s] += m : a[s] = m;
          }
        });
      }), P(a);
    }
  }, l = y({ pageSize: 10, pageNumber: 1 }), f = async (n = {}) => {
    try {
      const o = await j({ ...p, ...l }), e = S(o.list.content);
      r.splice(0, r.length, ...e);
    } catch (o) {
      console.log(o);
    }
  }, g = async () => {
    f();
  };
  return (n, o) => {
    const e = D, a = E;
    return w(), v("div", k, [t(T, { "header-title": "付款信息" }), t(a, { "max-height": "340", border: "", data: d(r), fit: "", "show-summary": "", "summary-method": h }, { default: A(() => [t(e, { type: "index", label: "序号", align: "center", width: "80" }), t(e, { prop: "paymentAmount", label: "付款", align: "center", "min-width": "120" }), t(e, { prop: "paymentDate", label: "日期", align: "center", "min-width": "120" }), t(e, { prop: "invoiceAmount", label: "发票", align: "center", "min-width": "120" }), t(e, { prop: "invoiceDate", label: "日期", align: "center", "min-width": "120" })]), _: 1 }, 8, ["data"]), t(C, { "request-data": l, total: d(u).invoiceInfo.total, onHandleChange: g }, null, 8, ["request-data", "total"])]);
  };
} };
export {
  N as default
};
