import { ref as b } from "vue";
import { watch as g } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as e } from "vue";
import { unref as t } from "vue";
import { withDirectives as h } from "vue";
import { createBlock as m } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as w } from "vue";
import { ElTableColumn as P } from "element-plus";
import { vLoading as C } from "element-plus";
import { c as N } from "../../../../../modules/coating-list-667107a8.js";
import v from "./module/from.vue.js";
import A from "./module/header.vue.js";
import { m as B, x as D, G as Q, an as R } from "../../../../../shared/runtime.js";
import { r as i } from "../../../../../modules/user-2de6904c.js";
import "./editList/index.vue.js";
import "./editList/module/detail.vue.js";
import "./editList/module/header.vue.js";
const M = { __name: "index", setup(U, { expose: d }) {
  const { globalProjectId: l } = B(["globalProjectId"]), u = { add: false, edit: false, del: false, download: false }, n = b(), { crud: r, CRUD: j } = D({ title: "涂装工艺", optShow: { ...u }, crudApi: { ...N }, hasPagination: false }, n);
  return g(() => l, (s) => {
    s && (r.query.contractProjectId = l, r.toQuery());
  }, { immediate: true, deep: true }), d({ getCoatingList: r.toQuery }), (s, I) => {
    const a = P, f = y("common-table"), _ = C;
    return o(), k("div", null, [x("div", null, [e(t(A))]), h((o(), m(f, { ref_key: "tableRef", ref: n, data: t(r).data, "empty-text": t(r).emptyText, "max-height": "220px" }, { default: p(() => [e(a, { label: "工艺编号", prop: "serialNumber", key: "serialNumber", align: "center" }), e(a, { label: "创建人", prop: "createUserName", key: "createUserName", align: "center" }), e(a, { label: "构件数量（件）", prop: "artifactQuantity", key: "artifactQuantity", align: "center" }), e(a, { label: "面积（㎡）", prop: "totalArea", key: "totalArea", align: "center" }), e(a, { label: "底漆 (种类/品牌【厚度】)", prop: "primer", key: "primer", align: "center" }), e(a, { label: "中间漆 (种类/品牌【厚度】)", prop: "intermediatePaint", key: "intermediatePaint", align: "center" }), e(a, { label: "面漆 (种类/品牌【厚度】)", prop: "topcoat", key: "topcoat", align: "center" }), t(Q)([...t(i).edit, ...t(i).del]) ? (o(), m(a, { key: 0, label: "操作", width: "180px", align: "center", fixed: "right" }, { default: p((c) => [e(t(R), { data: c.row, permission: t(i), delPrompt: `确认删除【工艺编号：${c.row.serialNumber}】吗？` }, null, 8, ["data", "permission", "delPrompt"])]), _: 1 })) : w("", true)]), _: 1 }, 8, ["data", "empty-text"])), [[_, t(r).loading]]), e(t(v))]);
  };
} };
export {
  M as default
};
