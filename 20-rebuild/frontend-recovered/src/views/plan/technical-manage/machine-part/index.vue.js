import { ref as f } from "vue";
import { watch as x } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as w } from "vue";
import { unref as e } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as l } from "vue";
import { withCtx as b } from "vue";
import { createCommentVNode as y } from "vue";
import { toDisplayString as E } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as q } from "element-plus";
import { c as B } from "../../../../modules/machine-part-99f84d79.js";
import { _ as I, m as D, x as N, o as U, T as V, i as A } from "../../../../shared/runtime.js";
import { E as H } from "../../../../modules/plan-d12d7ccf.js";
import L from "./module/header.vue.js";
import M from "./module/part-detail.vue.js";
import "../../../../modules/use-drawing-8a7ba23b.js";
import "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
const O = { class: "app-container" }, Q = { key: 0, style: { display: "flex" } }, $ = { style: { width: "40%", "margin-right": "10px" } }, z = { class: "head-container" }, G = { style: { color: "#409eff" } }, K = { style: { width: "59%", "padding-left": "10px" } }, W = { key: 1, class: "my-code" }, F = { key: 1, style: { color: "red", "font-size": "13px" } }, J = { __name: "index", setup(X) {
  const { globalProject: d, globalProjectId: p } = D(["globalProject", "globalProjectId"]), C = { add: false, edit: false, del: false, download: false }, g = f(), u = f(true), m = f({}), { crud: a, CRUD: k, columns: h } = N({ title: "零件清单", sort: ["id.asc"], permission: { ...H }, optShow: { ...C }, requiredQuery: ["projectId"], crudApi: { ...B }, hasPagination: false }, g), { maxHeight: T } = U({ wrapperBox: ".machine-part", paginate: true });
  x(() => p.value, (r) => {
    r && (a.query.projectId = p.value, a.toQuery());
  }, { immediate: true, deep: true }), x(() => d.value, (r) => {
    var n, t, s;
    ((t = (n = d.value) == null ? void 0 : n.projectContentList) == null ? void 0 : t.length) > 0 ? u.value = ((s = d.value) == null ? void 0 : s.projectContentList.findIndex((_) => _.no === V.STRUCTURE.V)) > -1 : u.value = true;
  }, { deep: true, immediate: true }), k.HOOK.handleRefresh = (r, n) => {
    const t = n.data;
    n.data.content = t;
  };
  function j(r) {
    m.value = r;
  }
  return (r, n) => {
    const t = S, s = P("common-table"), _ = q;
    return o(), c("div", O, [u.value ? (o(), c("div", Q, [i("div", $, [i("div", z, [w(e(L), { "project-id": e(p) }, null, 8, ["project-id"])]), R((o(), l(s, { ref_key: "tableRef", ref: g, data: e(a).data, "empty-text": e(a).emptyText !== "加载失败" ? e(a).emptyText : "暂无权限，请联系管理员", "return-source-data": "", showEmptySymbol: false, "max-height": e(T), onCurrentChange: j, "highlight-current-row": "", style: { width: "100%" }, onSortChange: e(a).handleSortChange }, { default: b(() => [w(t, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), e(h).visible("thick") ? (o(), l(t, { key: "thick", prop: "thick", "show-overflow-tooltip": true, label: "规格/厚度(mm)", align: "center" })) : y("", true), e(h).visible("material") ? (o(), l(t, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", align: "center" })) : y("", true), e(h).visible("quantity") ? (o(), l(t, { key: "quantity", prop: "quantity", label: "清单量(件/kg)", align: "left", "min-width": "80px" }, { default: b((v) => [i("span", G, E(v.row.quantity + " / " + v.row.totalNetWeight), 1)]), _: 1 })) : y("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[_, e(a).loading]])]), n[0] || (n[0] = i("div", { style: { "border-right": "1px solid #ededed", height: "calc(100vh - 160px)" } }, null, -1)), i("div", K, [e(A)(m.value) ? (o(), l(e(M), { key: 0, currentRow: m.value, steelPlateTypeEnum: e(a).query.steelPlateTypeEnum }, null, 8, ["currentRow", "steelPlateTypeEnum"])) : (o(), c("div", W, "*点击左表操作查看明细"))])])) : (o(), c("span", F, "当前项目内容没有包含构件,请到合同管理中进行配置"))]);
  };
} }, se = I(J, [["__scopeId", "data-v-f9279c53"]]);
export {
  se as default
};
