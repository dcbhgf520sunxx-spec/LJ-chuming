import { ref as p } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as H } from "vue";
import { createBlock as B } from "vue";
import { withCtx as r } from "vue";
import { createVNode as e } from "vue";
import { unref as t } from "vue";
import { createTextVNode as c } from "vue";
import { toDisplayString as d } from "vue";
import { isRef as E } from "vue";
import { ElTableColumn as C } from "element-plus";
import { u as R, x as S, o as v, x9 as u, xg as L, P as N } from "../../../../../shared/runtime.js";
import { g as k } from "../../../../../modules/user-322fe2e0.js";
import A from "./header.vue.js";
const j = { __name: "index", props: { modelValue: { type: Boolean, default: false } }, emits: ["update:modelValue"], setup(f, { emit: _ }) {
  const g = f, b = _, { visible: l, handleClose: x } = R({ emit: b, props: g }), n = p(), h = { del: false }, { crud: s } = S({ title: "变更记录", crudApi: { get: k }, optShow: { ...h }, hasPagination: true }, n), { maxHeight: T } = v({ mainBox: ".record-drawer", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", navbar: false, minHeight: 300, paginate: true, clientHRepMainH: true, extraHeight: 50 }, n), y = p([["createTime", ["parse-time"]]]);
  return (D, i) => {
    const a = C, w = m("common-table"), V = m("common-drawer");
    return H(), B(V, { "custom-class": "record-drawer", modelValue: t(l), "onUpdate:modelValue": i[0] || (i[0] = (o) => E(l) ? l.value = o : null), "before-close": t(x), size: "100%", title: "变更记录" }, { content: r(() => [e(A), e(w, { "data-format": y.value, "max-height": t(T), ref_key: "tableRef", ref: n, data: t(s).data, "empty-text": t(s).emptyText }, { default: r(() => [e(a, { label: "序号", type: "index", align: "center", width: "60" }), e(a, { label: "部门名称", align: "left", prop: "deptName" }), e(a, { label: "岗位名称", align: "left", prop: "jobName" }), e(a, { label: "姓名", align: "center", width: "140", prop: "name" }), e(a, { label: "电话号码", align: "center", width: "160", prop: "phone" }), e(a, { label: "用户类型", align: "center", prop: "userType" }, { default: r(({ row: o }) => [c(d(o.userType === 4 ? t(u).OUTSIDE_THE_ESTABLISHMENT.L : t(u).VL[o.userType]), 1)]), _: 1 }), e(a, { label: "操作类型", align: "center", prop: "crudType" }, { default: r(({ row: o }) => [c(d(t(L).VL[o.crudType]), 1)]), _: 1 }), e(a, { label: "变更时间", prop: "createTime", align: "center", width: "160" })]), _: 1 }, 8, ["data-format", "max-height", "data", "empty-text"]), e(N)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  j as default
};
