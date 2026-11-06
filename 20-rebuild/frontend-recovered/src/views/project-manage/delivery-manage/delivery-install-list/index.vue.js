import { ref as Q } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as u } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as a } from "vue";
import { withCtx as b } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as A } from "vue";
import { ElTableColumn as N } from "element-plus";
import { ElTag as q } from "element-plus";
import { vLoading as P } from "element-plus";
import { d as C } from "../../../../modules/report-list-f9da4d70.js";
import { _ as E, m as R, x as V, o as L, bN as g, kM as v, tQ as _, P as O } from "../../../../shared/runtime.js";
import { d as H } from "../../../../modules/project-19a12d6b.js";
import S from "./module/header.vue.js";
import "../../../../modules/area-ca564e60.js";
import "../../components/Panel/index.vue.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const D = { class: "app-container" }, B = { key: 0 }, U = { key: 1 }, M = { __name: "index", setup(W) {
  const { globalProjectId: c, globalProject: p } = R(["globalProjectId", "globalProject"]), f = { add: false, edit: false, del: false, download: false }, m = Q(), { crud: r, columns: l, CRUD: d } = V({ title: "收安报表", sort: ["id.desc"], permission: { ...H }, requiredQuery: ["projectId"], optShow: { ...f }, crudApi: { get: C }, hasPagination: true }, m), { maxHeight: h } = L({ wrapperBox: ".delivery-install-list", paginate: true, extraHeight: 40 });
  return d.HOOK.beforeRefresh = () => (r.query.projectId = p.value.businessType === g.INSTALLATION.V ? c.value : void 0, !!r.query.projectId), d.HOOK.handleRefresh = (w, n) => {
    n.data.content = n.data.content.map((t) => (t.stockQuantity = t.receivingQuantity ? t.receivingQuantity - t.installQuantity - t.unAuditQuantity : 0, t));
  }, (w, n) => {
    var y;
    const t = N, k = I("common-table"), x = q, T = P;
    return o(), u("div", D, [((y = e(p)) == null ? void 0 : y.businessType) === e(g).INSTALLATION.V ? (o(), u("div", B, [s(e(S), { projectId: e(c), globalProject: e(p) }, null, 8, ["projectId", "globalProject"]), j((o(), a(k, { ref_key: "tableRef", ref: m, data: e(r).data, "empty-text": e(r).emptyText, "max-height": e(h), stripe: false, style: { width: "100%" } }, { default: b(() => [s(t, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), e(l).visible("monomer.name") && e(r).query.productType !== e(v).ENCLOSURE.V ? (o(), a(t, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", align: "center" })) : i("", true), e(l).visible("area.name") ? (o(), a(t, { key: "area.name", prop: "area.name", "show-overflow-tooltip": true, label: e(r).query.productType !== e(v).ENCLOSURE.V ? "区域" : "批次", align: "center" }, null, 8, ["label"])) : i("", true), e(l).visible("name") ? (o(), a(t, { key: "name", prop: "name", label: "名称", "show-overflow-tooltip": true, align: "center" })) : i("", true), e(l).visible("serialNumber") ? (o(), a(t, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", align: "center" })) : i("", true), e(l).visible("material") ? (o(), a(t, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", align: "center" })) : i("", true), e(l).visible("specification") ? (o(), a(t, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", align: "center", "min-width": "120" })) : i("", true), e(l).visible("length") ? (o(), a(t, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", align: "center" })) : i("", true), e(l).visible("quantity") ? (o(), a(t, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "清单数量", align: "center" })) : i("", true), e(l).visible("netWeight") && e(r).query.productType === e(_).ARTIFACT.V ? (o(), a(t, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: "单重(kg)", align: "center" })) : i("", true), e(l).visible("mete") ? (o(), a(t, { key: "mete", prop: "mete", "show-overflow-tooltip": true, label: e(r).query.productType === e(_).ARTIFACT.V ? "总重(kg)" : "总长度(m)", align: "center" }, null, 8, ["label"])) : i("", true), e(l).visible("receivingQuantity") ? (o(), a(t, { key: "receivingQuantity", prop: "receivingQuantity", "show-overflow-tooltip": true, label: "已收货", align: "center" })) : i("", true), e(l).visible("installQuantity") ? (o(), a(t, { key: "installQuantity", prop: "installQuantity", "show-overflow-tooltip": true, label: "已安装", align: "center" })) : i("", true), e(l).visible("unAuditQuantity") ? (o(), a(t, { key: "unAuditQuantity", prop: "unAuditQuantity", "show-overflow-tooltip": true, label: "待审安装数", align: "center" })) : i("", true), e(l).visible("stockQuantity") ? (o(), a(t, { key: "stockQuantity", prop: "stockQuantity", "show-overflow-tooltip": true, label: "工地库存", align: "center" })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[T, e(r).loading]]), s(e(O))])) : (o(), u("div", U, [s(x, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: b(() => n[0] || (n[0] = [A(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [0] })]))]);
  };
} }, $ = E(M, [["__scopeId", "data-v-ccb04cc5"]]);
export {
  $ as default
};
