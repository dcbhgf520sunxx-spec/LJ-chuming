import { ref as u } from "vue";
import { inject as D } from "vue";
import { watch as B } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as b } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as g } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as E } from "vue";
import { createTextVNode as R } from "vue";
import { unref as s } from "vue";
import { ElTableColumn as j } from "element-plus";
import { ElButton as q } from "element-plus";
import { ElTable as N } from "element-plus";
import { vLoading as V } from "element-plus";
import { _ as A, eb as H, l6 as I, ec as F, iL as M } from "../../../../../../../../../shared/runtime.js";
import { d as z } from "../../../../../../../../../modules/upload-file-download-812f558c.js";
import { u as P } from "../../../../../../../../../modules/useTableTotal-3d22365a.js";
import { u as S } from "../../../../../../../../../modules/useTableHeight-90797a0b.js";
const U = { class: "collection-container" }, $ = { class: "download-container" }, G = { key: 1 }, J = { __name: "CollectionTable", setup(K, { expose: f }) {
  const i = u(false), d = u([]), { tableRef: h, maxHeight: y } = S(), { requestData: _, total: p, getSummaries: v } = P(false, { defineData: ["collectionAmount"] }), { projectInfo: l, _commonFn: w } = D("parent_data"), o = async () => {
    try {
      i.value = true;
      const { totalElements: e, content: n } = await I({ projectId: l.project.id, ..._ });
      p.value = e, d.value = F(n);
    } catch (e) {
      console.log(e);
    } finally {
      i.value = false;
    }
  };
  o(), w.value.getCollectionRecordList = o, B(() => {
    var e;
    return (e = l == null ? void 0 : l.project) == null ? void 0 : e.id;
  }, (e) => {
    o();
  });
  const x = async (e) => {
    await z(e.accessoryId, M);
  };
  return f({ getList: o }), (e, n) => {
    const a = j, C = q, T = N, k = V;
    return c(), b("div", U, [L((c(), g(T, { ref_key: "tableRef", ref: h, data: d.value, "max-height": s(y), "summary-method": s(v), border: "", "show-summary": "", stripe: "" }, { default: r(() => [t(a, { align: "center", label: "序号", type: "index" }), t(a, { align: "center", label: "收款日期", prop: "collectionDate" }), t(a, { align: "center", label: "收款类型", prop: "collectionMode" }), t(a, { align: "center", label: "收款金额", prop: "collectionAmount" }), t(a, { align: "center", label: "付款单位", "min-width": "120", prop: "paymentUnit", "show-overflow-tooltip": "" }), t(a, { align: "center", label: "收款行", prop: "collectionDepositBank" }), t(a, { align: "center", label: "办理人", prop: "writtenByName" }), t(a, { align: "center", label: "凭证", width: "100" }, { default: r(({ row: m }) => [E("div", $, [m.accessoryId ? (c(), g(C, { key: 0, icon: "el-icon-download", plain: "", size: "default", type: "primary", onClick: (O) => x(m) }, { default: r(() => n[0] || (n[0] = [R("下载 ")])), _: 2, __: [0] }, 1032, ["onClick"])) : (c(), b("span", G, "无"))])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[k, i.value]]), t(H, { "request-data": s(_), total: s(p), onHandleChange: o }, null, 8, ["request-data", "total"])]);
  };
} }, ee = A(J, [["__scopeId", "data-v-a6b4b363"]]);
export {
  ee as default
};
