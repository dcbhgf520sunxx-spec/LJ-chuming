import { ref as U } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as m } from "vue";
import { unref as e } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as r } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as i } from "vue";
import { ElMessageBox as B } from "element-plus";
import { ElTableColumn as M } from "element-plus";
import { ElSwitch as R } from "element-plus";
import { vLoading as F } from "element-plus";
import { l as _, _ as L, x as P, g2 as w, o as D, br as O, cB as d, g3 as H, g4 as I, G as y, an as $, P as q } from "../../../../shared/runtime.js";
import G from "./module/header.vue.js";
import K from "./module/form.vue.js";
function Y(o) {
  return _({ module: "contract", url: "branchCompany", method: "get", params: o });
}
function j(o) {
  return _({ module: "contract", url: "branchCompany", method: "post", data: o });
}
function z(o) {
  return _({ module: "contract", url: "branchCompany", method: "put", data: o });
}
function J(o) {
  return _({ module: "contract", url: "branchCompany", method: "delete", data: o });
}
function Q(o) {
  return _({ module: "contract", url: "branchCompany/enabled", method: "put", params: o });
}
const W = { get: Y, add: j, edit: z, del: J };
const X = { class: "app-container" }, Z = { class: "head-container" }, ee = { __name: "index", setup(o) {
  const E = { add: true, edit: false, del: false, download: false }, f = U(), { crud: b, columns: s, CRUD: v } = P({ title: "分支机构", sort: [], permission: { ...w }, optShow: { ...E }, crudApi: { ...W }, hasPagination: true }, f), { maxHeight: x } = D({ wrapperBox: ".branchCompanyConfig", paginate: true, extraHeight: 40 });
  async function C(h, u) {
    try {
      await B.confirm('此操作将 "' + d.VL[u] + '" ' + h.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await Q({ id: h.id, enabled: u }), b.refresh(), b.notify(d.VL[u] + "成功", v.NOTIFICATION_TYPE.SUCCESS);
    } catch (a) {
      console.log("变更公司状态", a), h.enabled = h.enabled === d.ENUM.TRUE.V ? d.ENUM.FALSE.V : d.ENUM.TRUE.V;
    }
  }
  return v.HOOK.handleRefresh = (h, u) => {
    u.data.content = u.data.content.map((a) => (a.bankAccounts = a.bankAccounts || [], a));
  }, (h, u) => {
    const a = M, k = R, V = T("common-table"), N = F;
    return n(), A("div", X, [c("div", Z, [m(e(G))]), S((n(), r(V, { ref_key: "tableRef", ref: f, data: e(b).data, "empty-text": e(b).emptyText, "max-height": e(x), showEmptySymbol: false, "return-source-data": "", style: { width: "100%" } }, { default: l(() => [m(a, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), e(s).visible("name") ? (n(), r(a, { key: "name", "show-overflow-tooltip": true, align: "center", label: "公司名称", "min-width": "150", prop: "name" }, { default: l((t) => [m(O, { show: t.row.isParent === e(d).ENUM.TRUE.V, name: "母公司" }, null, 8, ["show"]), c("div", null, p(t.row.name), 1)]), _: 1 })) : i("", true), e(s).visible("shortName") ? (n(), r(a, { key: "shortName", "show-overflow-tooltip": true, align: "center", label: "简称", "min-width": "150", prop: "shortName" }, { default: l((t) => [c("div", null, p(t.row.shortName || "-"), 1)]), _: 1 })) : i("", true), e(s).visible("level") ? (n(), r(a, { key: "level", "show-overflow-tooltip": true, align: "center", label: "单位属性", "min-width": "150", prop: "level" }, { default: l((t) => [c("div", null, p(e(H).VL[t.row.level]), 1)]), _: 1 })) : i("", true), e(s).visible("sort") ? (n(), r(a, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序", "min-width": "80" }, { default: l((t) => [c("span", null, p(t.row.sort), 1)]), _: 1 })) : i("", true), e(s).visible("branchAttributeEnum") ? (n(), r(a, { key: "branchAttributeEnum", "show-overflow-tooltip": true, align: "center", label: "属性", "min-width": "150", prop: "branchAttributeEnum" }, { default: l((t) => [c("div", null, p(e(I).VL[t.row.branchAttributeEnum]), 1)]), _: 1 })) : i("", true), e(s).visible("sort") ? (n(), r(a, { key: "sort", "show-overflow-tooltip": true, align: "center", label: "排序", "min-width": "80", prop: "sort" }, { default: l((t) => [c("span", null, p(t.row.sort), 1)]), _: 1 })) : i("", true), e(s).visible("remark") ? (n(), r(a, { key: "remark", align: "center", label: "备注", "min-width": "260", prop: "remark" }, { default: l((t) => [c("span", null, p(t.row.remark || "-"), 1)]), _: 1 })) : i("", true), e(s).visible("enabled") ? (n(), r(a, { key: "enabled", align: "center", label: "状态", "min-width": "260", prop: "enabled" }, { default: l((t) => [m(k, { modelValue: t.row.enabled, "onUpdate:modelValue": (g) => t.row.enabled = g, "active-value": e(d).ENUM.TRUE.V, disabled: !e(y)(e(w).edit), "inactive-value": e(d).ENUM.FALSE.V, "active-color": "#409EFF", "inactive-color": "#F56C6C", onChange: (g) => C(t.row, t.row.enabled) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "disabled", "inactive-value", "onChange"])]), _: 1 })) : i("", true), e(y)([...e(w).del, ...e(w).edit]) ? (n(), r(a, { key: 8, align: "center", fixed: "right", label: "操作", width: "130px" }, { default: l((t) => [m(e($), { data: t.row }, null, 8, ["data"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[N, e(b).loading]]), m(e(q)), m(e(K))]);
  };
} }, re = L(ee, [["__scopeId", "data-v-de50c8f0"]]);
export {
  re as default
};
