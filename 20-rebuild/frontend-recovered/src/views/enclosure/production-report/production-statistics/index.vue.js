import { ref as m } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as a } from "vue";
import { withCtx as x } from "vue";
import { createCommentVNode as r } from "vue";
import { ElTableColumn as L } from "element-plus";
import { vLoading as E } from "element-plus";
import { c as S, _ as T } from "./module/header.vue.js";
import { D as d, x as C, o as N, P as R, ba as D } from "../../../../shared/runtime.js";
import { h as M } from "../../../../modules/enclosure-365a2177.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const P = { class: "app-container" }, V = { __name: "index", setup(j) {
  const u = { add: false, edit: false, del: false, download: false }, p = m(), h = m([["project", "parse-project"], ["totalLength", ["to-fixed", d.MES_ENCLOSURE_L__M]], ["completeTime", ["parse-time", "{y}-{m}-{d}"]]]), { crud: i, columns: l, CRUD: b } = C({ title: "车间报表", sort: [], optShow: { ...u }, permission: { ...M }, crudApi: { ...S }, hasPagination: true }, p), { maxHeight: g } = N({ minHeight: 200, paginate: true });
  function f(n) {
    return D(n, { props: [["totalLength", d.MES_ENCLOSURE_L__M]] });
  }
  return b.HOOK.handleRefresh = async (n, { data: c }) => {
    c.content.forEach((t) => {
      t.totalLength = (t.totalLength || 0) / 1e3;
    });
  }, (n, c) => {
    const t = L, _ = w("common-table"), v = E;
    return o(), y("div", P, [s(e(T), { class: "head-container" }), k((o(), a(_, { ref_key: "tableRef", ref: p, data: e(i).data, "data-format": h.value, "empty-text": e(i).emptyText, "max-height": e(g), "summary-method": f, "show-summary": "" }, { default: x(() => [s(t, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), e(l).visible("project") ? (o(), a(t, { key: "project.shortName", "show-overflow-tooltip": true, align: "center", label: "项目", prop: "project" })) : r("", true), e(l).visible("name") ? (o(), a(t, { key: "name", "show-overflow-tooltip": true, align: "center", label: "名称", prop: "name" })) : r("", true), e(l).visible("serialNumber") ? (o(), a(t, { key: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "编号", prop: "serialNumber" })) : r("", true), e(l).visible("plate") ? (o(), a(t, { key: "plate", align: "center", label: "板型", prop: "plate", "show-overflow-tooltip": "" })) : r("", true), e(l).visible("bendTimes") ? (o(), a(t, { key: "bendTimes", align: "center", label: "弯折次数", prop: "bendTimes", "show-overflow-tooltip": "" })) : r("", true), e(l).visible("brand") ? (o(), a(t, { key: "brand", align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" })) : r("", true), e(l).visible("color") ? (o(), a(t, { key: "color", align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" })) : r("", true), e(l).visible("length") ? (o(), a(t, { key: "length", align: "right", label: "单长(mm)", prop: "length", "show-overflow-tooltip": "" })) : r("", true), e(l).visible("producedQuantity") ? (o(), a(t, { key: "producedQuantity", "show-overflow-tooltip": true, align: "center", label: "数量", prop: "producedQuantity" })) : r("", true), e(l).visible("totalLength") ? (o(), a(t, { key: "totalLength", align: "right", label: "总长度(m)", prop: "totalLength", "show-overflow-tooltip": "" })) : r("", true), e(l).visible("completeTime") ? (o(), a(t, { key: "completeTime", align: "center", label: "生产日期", prop: "completeTime", "show-overflow-tooltip": "" })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[v, e(i).loading]]), s(e(R))]);
  };
} };
export {
  V as default
};
