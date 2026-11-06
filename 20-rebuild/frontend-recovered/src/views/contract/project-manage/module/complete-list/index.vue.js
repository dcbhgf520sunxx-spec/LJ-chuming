import { ref as f } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as O } from "vue";
import { withDirectives as H } from "vue";
import { unref as t } from "vue";
import { createBlock as r } from "vue";
import { withCtx as n } from "vue";
import { createVNode as d } from "vue";
import { createCommentVNode as l } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as c } from "vue";
import { createTextVNode as M } from "vue";
import { ElTableColumn as U } from "element-plus";
import { ElTooltip as $ } from "element-plus";
import { ElPopconfirm as q } from "element-plus";
import { vLoading as z } from "element-plus";
import { _ as F, t as K, x as G, kh as Y, o as J, bN as Q, K as W, bV as X, G as T, c1 as Z, P as ee, kj as te } from "../../../../../shared/runtime.js";
import { L as C } from "../../../../../modules/contract-9b18cc88.js";
import oe from "../../../info/index.vue.js";
import "../../../info/zn-base.vue.js";
import "../../../info/customer.vue.js";
import "../../../../../modules/region-cascader-39b54da2.js";
import "../../../info/members.vue.js";
import "../../../info/money-form.vue.js";
import "../../../info/components/user-dept-cascader.vue.js";
import "../../../../../modules/UploadBtn-b4cfb47a.js";
import "../../../info/settle-form.vue.js";
import "../../../info/variation-order.vue.js";
const ae = { __name: "index", emits: ["success"], setup(ne, { emit: k }) {
  const _ = C.completeList, N = { add: true, edit: false, del: false, download: false }, { decimalPrecision: D } = K(), b = f(), w = f(), h = f(), v = f(), y = f(false), S = k, { crud: u, columns: i, CRUD: g } = G({ title: "完工列表", permission: { ..._ }, optShow: { ...N }, crudApi: { ...Y }, hasPagination: true }, b), { maxHeight: E } = J({ wrapperBox: ".completeProject", paginate: true, extraHeight: 40 });
  async function V(p, m) {
    try {
      await te(p.id, m, true), u.notify(`“${p.name}” 确认完工成功`, g.NOTIFICATION_TYPE.SUCCESS), u.refresh(), setTimeout(() => {
        S("success");
      }, 400);
    } catch (o) {
      console.log(o);
    }
  }
  function P(p) {
    w.value = p.id, h.value = p.status, v.value = p.name, y.value = true;
  }
  return g.HOOK.beforeRefresh = () => {
    u.query.outFinishStatus = 1;
  }, (p, m) => {
    const o = U, I = $, x = j("common-button"), A = q, L = j("common-table"), R = z;
    return a(), O("div", null, [H((a(), r(L, { ref_key: "tableRef", ref: b, data: t(u).data, "empty-text": t(u).emptyText, "max-height": t(E), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: n(() => [d(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index", fixed: "left" }), t(i).visible("serialNumber") ? (a(), r(o, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": false, "min-width": "130", align: "center", label: "合同编号", fixed: "left" })) : l("", true), t(i).visible("shortName") ? (a(), r(o, { key: "shortName", prop: "shortName", "show-overflow-tooltip": true, label: "项目", "min-width": "150" }, { default: n((e) => [d(I, { content: e.row.serialNumber + " " + e.row.name, "show-after": 50, placement: "top" }, { default: n(() => [s("span", null, c(e.row.shortName), 1)]), _: 2 }, 1032, ["content"])]), _: 1 })) : l("", true), t(i).visible("businessType") ? (a(), r(o, { key: "businessType", prop: "businessType", label: "业务类型", align: "center", width: "90" }, { default: n((e) => [s("div", null, c(e.row.businessType ? t(Q).VL[e.row.businessType] : "-"), 1)]), _: 1 })) : l("", true), t(i).visible("projectType") ? (a(), r(o, { key: "projectType", prop: "projectType", label: "项目类型", align: "center", width: "100" }, { default: n((e) => [s("div", null, c(e.row.projectType ? t(W).VL[e.row.projectType] : "-"), 1)]), _: 1 })) : l("", true), t(i).visible("projectContent") ? (a(), r(o, { key: "projectContent", "show-overflow-tooltip": true, prop: "projectContent", label: "项目内容", align: "center", "min-width": "150" }, { default: n((e) => [s("div", null, c(e.row.projectContent), 1)]), _: 1 })) : l("", true), t(i).visible("contractAmount") ? (a(), r(o, { key: "contractAmount", prop: "contractAmount", "show-overflow-tooltip": true, "min-width": "120", align: "center", label: "合同金额(元)" }, { default: n((e) => [s("span", null, c(e.row.contractAmount ? t(X)(e.row.contractAmount, t(D).contract) : "-"), 1)]), _: 1 })) : l("", true), t(i).visible("allDays") ? (a(), r(o, { key: "allDays", prop: "allDays", label: "总工期(天)", align: "center", width: "80" }, { default: n((e) => [s("div", null, c(e.row.allDays), 1)]), _: 1 })) : l("", true), t(i).visible("alreadyDays") ? (a(), r(o, { key: "alreadyDays", prop: "alreadyDays", label: "已用时(天)", align: "center", width: "80" }, { default: n((e) => [s("div", null, c(e.row.alreadyDays), 1)]), _: 1 })) : l("", true), t(i).visible("signerName") ? (a(), r(o, { key: "signerName", prop: "signerName", label: "签约人", align: "center", width: "100px" }, { default: n((e) => [s("div", null, c(e.row.signerName), 1)]), _: 1 })) : l("", true), d(o, { label: "操作", width: "180px", align: "center", fixed: "right" }, { default: n((e) => [t(T)(t(C).detail) ? (a(), r(x, { key: 0, size: "default", icon: "el-icon-view", type: "primary", onClick: (B) => P(e.row) }, null, 8, ["onClick"])) : l("", true), t(T)(t(_).completeConfirm) ? (a(), r(A, { key: 1, title: "确认完工么?", onConfirm: (B) => V(e.row, t(Z).COMPLETE.V) }, { reference: n(() => [d(x, { size: "default" }, { default: n(() => m[1] || (m[1] = [M("完工")])), _: 1, __: [1] })]), _: 2 }, 1032, ["onConfirm"])) : l("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[R, t(u).loading]]), d(t(oe), { "project-id": w.value, "project-status": h.value, "project-name": v.value, modelValue: y.value, "onUpdate:modelValue": m[0] || (m[0] = (e) => y.value = e), btnShow: false }, null, 8, ["project-id", "project-status", "project-name", "modelValue"]), d(t(ee))]);
  };
} }, he = F(ae, [["__scopeId", "data-v-d10e5b79"]]);
export {
  he as default
};
