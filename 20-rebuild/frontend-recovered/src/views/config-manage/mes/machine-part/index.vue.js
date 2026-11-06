import { ref as y } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as u } from "vue";
import { unref as e } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as l } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as i } from "vue";
import { Fragment as E } from "vue";
import { renderList as A } from "vue";
import { createTextVNode as B } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as R } from "element-plus";
import { c as H, a as j } from "./module/audit-form.vue.js";
import { _ as F, x as O, fz as d, o as T, G as v, an as U, P as q } from "../../../../shared/runtime.js";
import z from "./module/header.vue.js";
import M from "./module/form.vue.js";
import "../../../../modules/index-61ce89a1.js";
import "../../../../modules/mes-bridge-enum-radio-5a510e87.js";
import "../../../../modules/use-section-all-504a2069.js";
const G = { class: "app-container" }, K = { class: "head-container" }, Q = { __name: "index", setup($) {
  const I = { add: true, edit: false, del: false, download: false }, k = y(), S = y({}), w = y(false), { CRUD: L, crud: c, columns: b } = O({ title: "部件特征定义", sort: [], permission: { ...d }, optShow: { ...I }, crudApi: { ...H }, hasPagination: true }, k), { maxHeight: P } = T({ wrapperBox: ".machinePartConfig", paginate: true, extraHeight: 40 }), m = y([]);
  return L.HOOK.handleRefresh = (N, { data: n }) => {
    m.value = [], n.content.forEach((a) => {
      var p, f;
      a.boolSectionSteel && (a.classifyNames = a.classifyLinks.map((o) => o.classifyName).join("、"), a.classifyIds = a.classifyLinks.map((o) => o.classifyId), a.newClassifyNames = (p = a.newClassifyLinks) == null ? void 0 : p.map((o) => o.classifyName).join("、"), a.newClassifyIds = (f = a.newClassifyLinks) == null ? void 0 : f.map((o) => o.classifyId), m.value = m.value.concat(a.classifyIds));
    });
  }, (N, n) => {
    const a = D, p = C("common-button"), f = C("common-table"), o = R;
    return s(), h("div", G, [x("div", K, [u(e(z))]), V((s(), l(f, { ref_key: "tableRef", ref: k, class: "upload-table", data: e(c).data, "empty-text": e(c).emptyText, "max-height": e(P), "return-source-data": "", showEmptySymbol: false, stripe: false, style: { width: "100%" } }, { default: r(() => [u(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(b).visible("name") ? (s(), l(a, { key: "name", prop: "name", align: "center", "show-overflow-tooltip": true, label: "代表杆件类型", "min-width": "150" }, { default: r((t) => [x("span", null, g(t.row.name), 1)]), _: 1 })) : i("", true), e(b).visible("assembleSpecList") ? (s(), l(a, { key: "assembleSpecList", prop: "assembleSpecList", label: "部件规格前缀", "show-overflow-tooltip": true, align: "center", "min-width": "260" }, { default: r((t) => [t.row.assembleSpecList && t.row.assembleSpecList.length > 0 ? (s(true), h(E, { key: 0 }, A(t.row.assembleSpecList, (_) => (s(), h("span", { key: _.id }, g(_.specPrefix + "  " + (t.row.boolSectionSteel ? "【" + (_.specIndex ? _.specIndex : "全部") + "】" : "")), 1))), 128)) : i("", true)]), _: 1 })) : i("", true), e(b).visible("sort") ? (s(), l(a, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序", width: "80", align: "center" }, { default: r((t) => [x("span", null, g(t.row.sort), 1)]), _: 1 })) : i("", true), e(v)([...e(d).del, ...e(d).edit, ...e(d).audit]) ? (s(), l(a, { key: 3, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: r((t) => [t.row.auditStatus === 1 && e(v)(e(d).audit) ? (s(), l(p, { key: 0, type: "success", size: "default", onClick: () => {
      S.value = { ...t.row, mesProductEnum: e(c).query.mesProductEnum }, w.value = true;
    } }, { default: r(() => n[1] || (n[1] = [B("审核")])), _: 2, __: [1] }, 1032, ["onClick"])) : i("", true), t.row.auditStatus !== 1 ? (s(), l(e(U), { key: 1, data: t.row, permission: e(d) }, null, 8, ["data", "permission"])) : i("", true)]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[o, e(c).loading]]), u(e(q)), u(e(M), { boundAllClassifyIds: m.value }, null, 8, ["boundAllClassifyIds"]), u(e(j), { modelValue: w.value, "onUpdate:modelValue": n[0] || (n[0] = (t) => w.value = t), detailInfo: S.value, onSuccess: e(c).toQuery }, null, 8, ["modelValue", "detailInfo", "onSuccess"])]);
  };
} }, se = F(Q, [["__scopeId", "data-v-17a651e7"]]);
export {
  se as default
};
