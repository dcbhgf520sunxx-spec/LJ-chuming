import { ref as b } from "vue";
import { reactive as U } from "vue";
import { provide as h } from "vue";
import { resolveComponent as Y } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as T } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as f } from "vue";
import { withDirectives as H } from "vue";
import { unref as t } from "vue";
import { createBlock as n } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as l } from "vue";
import { Fragment as O } from "vue";
import { createTextVNode as G } from "vue";
import { ElTableColumn as I } from "element-plus";
import { ElTag as M } from "element-plus";
import { vLoading as $ } from "element-plus";
import { l as y, fg as q, x as z, g7 as J, D, o as K, p as Q, c3 as v, an as W, P as X, ba as Z } from "../../../../shared/runtime.js";
import { g as ee, a as te, b as ae } from "../../../../modules/common-f216149e.js";
import { t as C } from "../../../../modules/contract-9b18cc88.js";
import re from "./module/header.vue.js";
import oe from "./module/form.vue.js";
import "../../../../modules/dept-cascader-6af417b9.js";
import "../../../../modules/use-dept-b8e95315.js";
import "../../../../modules/index-7da9f094.js";
import "../../../../modules/use-users-4d979987.js";
import "../../../../modules/UploadBtn-b4cfb47a.js";
function ne(c) {
  return y({ module: "contract", url: "contract/reimbursement-fee/page", method: "get", params: c });
}
function se(c) {
  return y({ module: "contract", url: "contract/reimbursement-fee", method: "post", data: c });
}
function ie(c) {
  return y({ module: "contract", url: "contract/reimbursement-fee", method: "put", data: c });
}
function me(c) {
  return y({ module: "contract", url: `contract/reimbursement-fee/${c}`, method: "delete" });
}
const le = { get: ne, add: se, edit: ie, del: me }, ue = { class: "app-container" }, ce = { class: "head-container" }, xe = { __name: "index", setup(c) {
  const { projectTree: E } = q(), L = { add: true, edit: false, del: false, download: false }, N = b(), x = b([]), w = b(), k = b(), A = U({ info: 0 }), { crud: g, columns: u } = z({ title: "报销费用", optShow: { ...L }, permission: { ...C }, crudApi: { ...le }, hasPagination: true }, N);
  B(), h("summaryData", A), h("expenseList", x.value), h("projectList", k), h("projectTree", E);
  async function B() {
    var o, _, a;
    try {
      const { content: p } = await ee({ category: J.OTHER_CATEGORY.V });
      for (let d = 0; d < p.length; d++) x.value.push({ id: (o = p[d]) == null ? void 0 : o.id, name: (_ = p[d]) == null ? void 0 : _.name, links: (a = p[d]) == null ? void 0 : a.links });
    } catch (p) {
      console.log("获取费用类别失败", p);
    }
  }
  const j = b([["reimbursementAmount", ["to-thousand", D.YUAN]]]), { maxHeight: V } = K({ extraBox: [".head-container"], paginate: true });
  function S(o) {
    return Z(o, { props: [["reimbursementAmount", D.YUAN]], toThousandFields: ["reimbursementAmount"] });
  }
  async function P() {
    try {
      const { content: o } = await te();
      w.value = o;
    } catch (o) {
      console.log(o);
    }
  }
  P();
  async function R() {
    try {
      const o = await ae();
      k.value = o;
    } catch (o) {
      console.log(o);
    }
  }
  return R(), (o, _) => {
    const a = I, p = M, d = Y("common-table"), F = $;
    return r(), T("div", ue, [i("div", ce, [f(re, { branchList: w.value }, null, 8, ["branchList"])]), H((r(), n(d, { ref_key: "tableRef", ref: N, data: t(g).data, "empty-text": t(g).emptyText, "max-height": t(V), "row-key": "id", style: { width: "100%" }, "data-format": j.value, "show-summary": "", "summary-method": S }, { default: s(() => [f(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(u).visible("reimbursementDate") ? (r(), n(a, { align: "center", key: "reimbursementDate", prop: "reimbursementDate", "show-overflow-tooltip": true, label: "日期" }, { default: s((e) => [i("span", null, m(e.row.reimbursementDate ? t(Q)(e.row.reimbursementDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : l("", true), t(u).visible("branchCompanyName") ? (r(), n(a, { key: "branchCompanyName", prop: "branchCompanyName", label: "费用归属", align: "center" }, { default: s(({ row: e }) => [i("span", null, m(e.branchCompanyName), 1)]), _: 1 })) : l("", true), t(u).visible("deptName") ? (r(), n(a, { align: "center", key: "deptName", prop: "deptName", "show-overflow-tooltip": true, label: "部门" }, { default: s((e) => [i("span", null, m(e.row.deptName), 1)]), _: 1 })) : l("", true), t(u).visible("reimburserName") ? (r(), n(a, { align: "center", key: "reimburserName", prop: "reimburserName", "show-overflow-tooltip": true, label: "报销人" }, { default: s((e) => [i("span", null, m(e.row.reimburserName || "-"), 1)]), _: 1 })) : l("", true), t(u).visible("expenseTypeName") ? (r(), n(a, { align: "center", key: "expenseTypeName", prop: "expenseTypeName", "show-overflow-tooltip": true, label: "费用类型" }, { default: s((e) => [i("span", null, m(e.row.expenseTypeName), 1)]), _: 1 })) : l("", true), t(u).visible("reimbursementAmount") ? (r(), n(a, { align: "center", key: "reimbursementAmount", prop: "reimbursementAmount", "show-overflow-tooltip": true, label: "报销金额（元）" }, { default: s((e) => [i("span", null, m(e.row.reimbursementAmount), 1)]), _: 1 })) : l("", true), t(u).visible("projectName") ? (r(), n(a, { align: "center", key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "项目" }, { default: s((e) => [i("span", null, m(e.row.projectName || "-"), 1)]), _: 1 })) : l("", true), t(u).visible("writtenByName") ? (r(), n(a, { align: "center", key: "writtenByName", prop: "writtenByName", "show-overflow-tooltip": true, label: "填报人" }, { default: s((e) => [i("span", null, m(e.row.writtenByName), 1)]), _: 1 })) : l("", true), t(u).visible("reimbursementVoucherNumber") ? (r(), n(a, { align: "center", key: "reimbursementVoucherNumber", prop: "reimbursementVoucherNumber", "show-overflow-tooltip": true, label: "报销凭证号" }, { default: s((e) => [i("span", null, m(e.row.reimbursementVoucherNumber || "-"), 1)]), _: 1 })) : l("", true), t(u).visible("remark") ? (r(), n(a, { align: "center", key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注" }, { default: s((e) => [i("span", null, m(e.row.remark), 1)]), _: 1 })) : l("", true), f(a, { align: "center", label: "操作" }, { default: s((e) => [e.row.auditStatusEnum === t(v).AUDITING.V ? (r(), n(t(W), { key: 0, data: e.row, permission: t(C) }, null, 8, ["data", "permission"])) : (r(), T(O, { key: 1 }, [e.row.auditStatusEnum ? (r(), n(p, { key: 0, type: t(v).V[e.row.auditStatusEnum].TYPE }, { default: s(() => [G(m(t(v).VL[e.row.auditStatusEnum]), 1)]), _: 2 }, 1032, ["type"])) : l("", true)], 64))]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[F, t(g).loading]]), f(t(X)), f(oe, { branchList: w.value }, null, 8, ["branchList"])]);
  };
} };
export {
  xe as default
};
