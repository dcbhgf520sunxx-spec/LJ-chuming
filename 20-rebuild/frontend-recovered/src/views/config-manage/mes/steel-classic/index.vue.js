import { ref as b } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as i } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as m } from "vue";
import { unref as s } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as l } from "vue";
import { withCtx as o } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as n } from "vue";
import { Fragment as C } from "vue";
import { renderList as k } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as B } from "element-plus";
import { _ as H, x as P, fG as h, fH as R, o as F, f9 as L, G as O, an as V } from "../../../../shared/runtime.js";
import $ from "./module/header.vue.js";
import T from "./module/form.vue.js";
import "../../../../modules/mes-bridge-enum-radio-5a510e87.js";
import "../../../../modules/use-section-all-504a2069.js";
const G = { class: "app-container" }, M = { class: "head-container" }, U = { key: 1 }, j = { key: 1 }, q = { __name: "index", setup(K) {
  const x = { add: true, edit: false, del: false, download: false }, w = b(), { crud: f, columns: r, CRUD: g } = P({ title: "零件特征定义", sort: [], permission: { ...h }, optShow: { ...x }, crudApi: { ...R }, hasPagination: false }, w), { maxHeight: v } = F({ wrapperBox: ".collection", paginate: true, extraHeight: 40 }), p = b([]);
  return g.HOOK.handleRefresh = (N, { data: y }) => {
    p.value = [], y.content.forEach((a) => {
      a.classifyNames = a.classifyLinks.map((_) => _.classifyName).join("、"), a.classifyIds = a.boundFinalClassifyIds, p.value = p.value.concat(a.boundFinalClassifyIds), a.steelClassNamePrefixDTOParams = a.steelClassNames;
    });
  }, (N, y) => {
    const a = A, _ = D("common-table"), E = B;
    return t(), i("div", G, [u("div", M, [m(s($))]), S((t(), l(_, { class: "upload-table", ref_key: "tableRef", ref: w, data: s(f).data, "empty-text": s(f).emptyText, "max-height": s(v), stripe: false, "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: o(() => [m(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), s(r).visible("productClassificationEnum") ? (t(), l(a, { key: "productClassificationEnum", "show-overflow-tooltip": true, prop: "productClassificationEnum", label: "类型", align: "center", width: "120" }, { default: o((e) => [u("span", null, c(e.row.productClassificationEnum ? s(L).V[e.row.productClassificationEnum].SL : "-"), 1)]), _: 1 })) : n("", true), s(r).visible("name") ? (t(), l(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", align: "center", "min-width": "150" }, { default: o((e) => [u("span", null, c(e.row.name), 1)]), _: 1 })) : n("", true), s(r).visible("steelClassNames") ? (t(), l(a, { key: "steelClassNames", prop: "steelClassNames", "show-overflow-tooltip": true, label: "匹配名称", align: "center", "min-width": "150" }, { default: o((e) => [e.row.steelClassNames && e.row.steelClassNames.length > 0 ? (t(true), i(C, { key: 0 }, k(e.row.steelClassNames, (d, I) => (t(), i("span", { key: I }, c(`【${d}】`), 1))), 128)) : (t(), i("div", U, "-"))]), _: 1 })) : n("", true), s(r).visible("classifyNames") ? (t(), l(a, { key: "classifyNames", prop: "classifyNames", "show-overflow-tooltip": true, label: "零件科目", "min-width": "260" }, { default: o((e) => [u("span", null, c(e.row.classifyNames), 1)]), _: 1 })) : n("", true), s(r).visible("links") ? (t(), l(a, { key: "links", prop: "links", "show-overflow-tooltip": true, label: "规格前缀索引", align: "center", "min-width": "260" }, { default: o((e) => [e.row.links && e.row.links.length > 0 ? (t(true), i(C, { key: 0 }, k(e.row.links, (d) => (t(), i("span", { key: d.id }, c(`${d.keyword}【${d.specIndex ? d.specIndex : "全部"}】`), 1))), 128)) : (t(), i("div", j, "-"))]), _: 1 })) : n("", true), s(r).visible("sort") ? (t(), l(a, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序", width: "80", align: "center" }, { default: o((e) => [u("span", null, c(e.row.sort), 1)]), _: 1 })) : n("", true), s(O)([...s(h).del, ...s(h).edit]) ? (t(), l(a, { key: 6, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: o((e) => [m(s(V), { data: e.row }, null, 8, ["data"])]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[E, s(f).loading]]), m(s(T), { boundAllClassifyIds: p.value }, null, 8, ["boundAllClassifyIds"])]);
  };
} }, Z = H(q, [["__scopeId", "data-v-02ddaba2"]]);
export {
  Z as default
};
