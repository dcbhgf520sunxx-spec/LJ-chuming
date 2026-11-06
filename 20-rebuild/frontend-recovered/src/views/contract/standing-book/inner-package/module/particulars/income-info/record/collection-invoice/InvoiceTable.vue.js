import { ref as v } from "vue";
import { inject as f } from "vue";
import { toRefs as E } from "vue";
import { watch as I } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as _ } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as g } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as h } from "vue";
import { unref as c } from "vue";
import { createCommentVNode as j } from "vue";
import { createTextVNode as q } from "vue";
import { ElTableColumn as A } from "element-plus";
import { ElButton as H } from "element-plus";
import { ElTable as S } from "element-plus";
import { vLoading as F } from "element-plus";
import { _ as P, bD as y, eb as U, l7 as z, ec as M, iL as $ } from "../../../../../../../../../shared/runtime.js";
import { d as G } from "../../../../../../../../../modules/upload-file-download-812f558c.js";
import { u as J } from "../../../../../../../../../modules/useTableTotal-3d22365a.js";
import { u as K } from "../../../../../../../../../modules/useTableHeight-90797a0b.js";
const O = { class: "invoice-container" }, Q = { key: 0 }, W = { class: "download-container" }, X = { key: 1 }, Y = { __name: "InvoiceTable", setup(Z, { expose: w }) {
  const d = v(false), { requestData: m, total: u, getSummaries: x } = J(false, { defineData: ["actualInvoiceAmount"] }), { tableRef: T, maxHeight: D } = K(), k = f("parent_data"), { _commonFn: B } = k, { projectInfo: s } = E(f("parent_data")), p = v([]), l = async () => {
    try {
      d.value = true;
      const { content: a, totalElements: o } = await z({ projectId: s.value.project.id, ...m });
      p.value = M(a), p.value.forEach((e) => {
        e.invoiceTypeName = y.VL[e.invoiceType];
      }), u.value = o;
    } catch (a) {
      console.log(a);
    } finally {
      d.value = false;
    }
  };
  l(), B.value.getBillingRecordList = l, I(() => {
    var a, o;
    return (o = (a = s == null ? void 0 : s.value) == null ? void 0 : a.project) == null ? void 0 : o.id;
  }, (a) => {
    l();
  });
  const N = async (a) => {
    await G(a.accessoryId, $);
  };
  return w({ getList: l }), (a, o) => {
    const e = A, L = H, V = S, C = F;
    return i(), _("div", O, [R((i(), g(V, { ref_key: "tableRef", ref: T, data: p.value, "max-height": c(D), "summary-method": c(x), border: "", "show-summary": "", stripe: "" }, { default: r(() => [t(e, { align: "center", fixed: "", label: "序号", type: "index" }), t(e, { align: "center", fixed: "", label: "开票日期", prop: "invoiceDate", width: "100" }), t(e, { align: "center", fixed: "", label: "发票类型", prop: "invoiceTypeName", width: "140" }, { default: r(({ row: n }) => [b("span", null, h(n.invoiceTypeName) + "  ", 1), c(y).V[n.invoiceType].V !== 4 ? (i(), _("span", Q, "(" + h(n.taxRate) + "%)", 1)) : j("", true)]), _: 1 }), t(e, { align: "center", fixed: "", label: "发票金额", prop: "actualInvoiceAmount", width: "160" }), t(e, { align: "center", label: "开票单位", prop: "invoiceUnit", width: "240" }), t(e, { align: "center", label: "收票单位", prop: "collectionUnit", width: "240" }), t(e, { align: "center", label: "发票编号", prop: "invoiceNo", width: "140" }), t(e, { align: "center", label: "办理人", prop: "writtenByName", width: "100" }), t(e, { align: "center", label: "凭证", width: "100" }, { default: r(({ row: n }) => [b("div", W, [n.attachments ? (i(), g(L, { key: 0, icon: "el-icon-download", plain: "", size: "default", type: "primary", onClick: (ee) => N(n) }, { default: r(() => o[0] || (o[0] = [q("下载 ")])), _: 2, __: [0] }, 1032, ["onClick"])) : (i(), _("span", X, "无"))])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[C, d.value]]), t(U, { "request-data": c(m), total: c(u), onHandleChange: l }, null, 8, ["request-data", "total"])]);
  };
} }, ie = P(Y, [["__scopeId", "data-v-b700a751"]]);
export {
  ie as default
};
