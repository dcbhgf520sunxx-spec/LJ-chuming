import { ref as g } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as n } from "vue";
import { createElementVNode as B } from "vue";
import { createVNode as x } from "vue";
import { unref as e } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as r } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as s } from "vue";
import { Fragment as y } from "vue";
import { renderList as w } from "vue";
import { toDisplayString as N } from "vue";
import { createTextVNode as h } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as H, a as I } from "./module/audit-form.vue.js";
import { _ as O, x as U, f4 as f, o as q, i as C, G as T, an as M, es as j, f5 as z } from "../../../../shared/runtime.js";
import G from "./module/form.vue.js";
import K from "./module/header.vue.js";
import "../../../../modules/index-61ce89a1.js";
import "../../../../modules/use-section-all-504a2069.js";
import "../../../../modules/mes-bridge-enum-radio-5a510e87.js";
const Q = { class: "app-container" }, $ = { class: "head-container" }, J = { __name: "index", setup(W) {
  const L = { add: true, edit: false, del: false, download: false }, k = g(), A = [["artifactType", ["parse-enum", j]], ["codingType", ["parse-enum", z]]], P = g({}), b = g(false), { CRUD: R, crud: m, columns: l } = U({ title: "构件类型定义", sort: ["id.desc"], permission: { ...f }, optShow: { ...L }, crudApi: { ...H }, hasPagination: false }, k), { maxHeight: S } = q({ wrapperBox: ".artifact-type-config", paginate: true, extraHeight: 80 });
  return R.HOOK.handleRefresh = (V, { data: o }) => {
    const i = [];
    o.content.map((_) => {
      _.structureClassificationList.map((c) => {
        c.serialNumberPrefixArr = c.serialNumberPrefixList.map((u) => u.serialNumberPrefix), c.specPrefixArr = c.specPrefixList.map((u) => u.specPrefix);
      }), i.push(..._.structureClassificationList);
    }), o.content = i;
  }, (V, o) => {
    const i = D, _ = v("common-button"), c = v("common-table"), u = F;
    return t(), n("div", Q, [B("div", $, [x(e(K))]), E((t(), r(c, { ref_key: "tableRef", ref: k, "max-height": e(S), "data-format": A, data: e(m).data }, { default: p(() => [x(i, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(l).visible("artifactType") ? (t(), r(i, { key: "artifactType", "show-overflow-tooltip": true, prop: "artifactType", label: "类型", align: "center", width: "120" })) : s("", true), e(l).visible("classificationName") ? (t(), r(i, { key: "classificationName", prop: "classificationName", label: "构件类型", width: "180", align: "left" })) : s("", true), e(l).visible("serialNumberPrefixArr") ? (t(), r(i, { key: "serialNumberPrefixArr", prop: "serialNumberPrefixArr", label: "匹配名称", align: "left" }, { default: p(({ row: { sourceRow: a } }) => [e(C)(a.serialNumberPrefixArr) ? (t(true), n(y, { key: 0 }, w(a.serialNumberPrefixArr, (d) => (t(), n("span", { key: d.id }, " 【" + N(d) + "】 ", 1))), 128)) : (t(), n(y, { key: 1 }, [h(" - ")], 64))]), _: 1 })) : s("", true), e(l).visible("specPrefixList") ? (t(), r(i, { key: "specPrefixList", prop: "specPrefixList", label: "截面类型", align: "left" }, { default: p(({ row: { sourceRow: a } }) => [e(C)(a.specPrefixList) ? (t(true), n(y, { key: 0 }, w(a.specPrefixList, (d) => (t(), n("span", { key: d.name }, " 【" + N(d.specPrefix) + "】 ", 1))), 128)) : (t(), n(y, { key: 1 }, [h(" - ")], 64))]), _: 1 })) : s("", true), e(l).visible("codingType") ? (t(), r(i, { key: "codingType", prop: "codingType", label: "扫码方式", width: "120", align: "left" })) : s("", true), e(l).visible("sort") ? (t(), r(i, { key: "sort", prop: "sort", label: "排序", width: "100", align: "left" })) : s("", true), e(T)([...e(f).del, ...e(f).edit, ...e(f).audit]) ? (t(), r(i, { key: 6, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: p(({ row: { sourceRow: a } }) => [a.auditStatus !== 1 ? (t(), r(e(M), { key: 0, data: a }, null, 8, ["data"])) : s("", true), a.auditStatus === 1 && e(T)(e(f).audit) ? (t(), r(_, { key: 1, type: "success", size: "default", onClick: () => {
      P.value = { ...a, mesProductEnum: e(m).query.mesProductEnum }, b.value = true;
    } }, { default: p(() => o[1] || (o[1] = [h("审核")])), _: 2, __: [1] }, 1032, ["onClick"])) : s("", true)]), _: 1 })) : s("", true)]), _: 1 }, 8, ["max-height", "data"])), [[u, e(m).loading]]), x(G), x(e(I), { modelValue: b.value, "onUpdate:modelValue": o[0] || (o[0] = (a) => b.value = a), detailInfo: P.value, onSuccess: e(m).toQuery }, null, 8, ["modelValue", "detailInfo", "onSuccess"])]);
  };
} }, se = O(J, [["__scopeId", "data-v-5d506861"]]);
export {
  se as default
};
