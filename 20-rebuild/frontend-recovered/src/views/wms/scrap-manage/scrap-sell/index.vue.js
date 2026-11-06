import { ref as s } from "vue";
import { resolveComponent as S } from "vue";
import { resolveDirective as T } from "vue";
import { openBlock as A } from "vue";
import { createElementBlock as $ } from "vue";
import { createVNode as e } from "vue";
import { withCtx as m } from "vue";
import { unref as l } from "vue";
import { createTextVNode as P } from "vue";
import { toDisplayString as U } from "vue";
import { withDirectives as p } from "vue";
import { ElMessage as N } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { ElTag as R } from "element-plus";
import { c as I, d as Q } from "../../../../modules/scrap-sell-e306ced6.js";
import { x as B, Co as F, c3 as c, P as L } from "../../../../shared/runtime.js";
import M from "./module/header.vue.js";
import j from "./module/check-detail.vue.js";
import q from "./module/view-detail.vue.js";
import G from "./module/detail.vue.js";
import "../../../../modules/scrap-ledger-452ee452.js";
const H = { class: "app-container" }, ae = { __name: "index", setup(J) {
  const h = s([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["saleDate", ["parse-time", "{y}-{m}-{d}"]], ["auditTime", ["parse-time", "{y}-{m}-{d}"]]]), { crud: n } = B({ title: "废料出售", crudApi: { ...I }, sort: [], permission: { ...F } }), f = s(false), _ = s(false), u = s({}), g = s({}), b = s(false);
  function w(o) {
    f.value = true, u.value = o;
  }
  function V() {
    n.toQuery();
  }
  function y(o) {
    _.value = true, u.value = o;
  }
  function k(o) {
    b.value = true, g.value = o;
  }
  function C() {
    n.toQuery();
  }
  async function D(o) {
    const i = [];
    i.push(o.id);
    try {
      await Q(i), n.toQuery(), N({ message: "删除成功", type: "success" });
    } catch (a) {
      console.log(a);
    }
  }
  return (o, i) => {
    const a = z, E = R, r = S("common-button"), x = S("common-table"), d = T("permission");
    return A(), $("div", H, [e(M), e(x, { data: l(n).data, style: { width: "100%" }, "data-format": h.value }, { default: m(() => [e(a, { label: "序号", width: "60", align: "center", type: "index" }), e(a, { label: "出售日期", width: "150", align: "center", prop: "saleDate" }), e(a, { label: "购买单位", width: "200", align: "center", prop: "purchaser" }), e(a, { label: "合同编号", width: "200", align: "center", prop: "serialNumber" }), e(a, { label: "总金额", width: "120", align: "center", prop: "totalAmount" }), e(a, { label: "创建人", width: "100", align: "center", prop: "createUserName" }), e(a, { label: "创建日期", width: "150", align: "center", prop: "createTime" }), e(a, { label: "审核人", width: "100", align: "center", prop: "auditUserName" }), e(a, { label: "审核日期", width: "150", align: "center", prop: "auditTime" }), e(a, { label: "审核状态", width: "120", align: "center", fixed: "right" }, { default: m(({ row: t }) => [e(E, { size: "large", type: t.auditStatusEnum === l(c).AUDITING.V ? "info" : t.auditStatusEnum === l(c).PASS.V ? "success" : "danger" }, { default: m(() => [P(U(l(c).VL[t.auditStatusEnum]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), e(a, { label: "操作", align: "center", fixed: "right" }, { default: m(({ row: t }) => [p(e(r, { type: "primary", icon: "el-icon-view", size: "default", onClick: (v) => y(t) }, null, 8, ["onClick"]), [[d, l(n).permission.get]]), p(e(r, { type: "success", icon: "el-icon-edit", size: "default", disabled: t.auditStatusEnum === l(c).PASS.V, onClick: (v) => k(t) }, null, 8, ["disabled", "onClick"]), [[d, l(n).permission.edit]]), p(e(r, { type: "warning", icon: "el-icon-stamp", size: "default", disabled: t.auditStatusEnum === l(c).PASS.V, onClick: (v) => w(t) }, null, 8, ["disabled", "onClick"]), [[d, l(n).permission.check]]), p(e(r, { type: "danger", icon: "el-icon-delete", size: "default", disabled: t.auditStatusEnum === l(c).PASS.V, onClick: (v) => D(t) }, null, 8, ["disabled", "onClick"]), [[d, l(n).permission.del]])]), _: 1 })]), _: 1 }, 8, ["data", "data-format"]), e(l(L)), e(j, { modelValue: f.value, "onUpdate:modelValue": i[0] || (i[0] = (t) => f.value = t), rowData: u.value, onSuccess: V }, null, 8, ["modelValue", "rowData"]), e(q, { modelValue: _.value, "onUpdate:modelValue": i[1] || (i[1] = (t) => _.value = t), rowData: u.value }, null, 8, ["modelValue", "rowData"]), e(G, { title: "修改废料出售", rowData: g.value, modelValue: b.value, "onUpdate:modelValue": i[2] || (i[2] = (t) => b.value = t), onSuccess: C }, null, 8, ["rowData", "modelValue"])]);
  };
} };
export {
  ae as default
};
