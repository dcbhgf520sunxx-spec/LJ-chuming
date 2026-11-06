import { ref as T } from "vue";
import { resolveComponent as W } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { withDirectives as v } from "vue";
import { createBlock as i } from "vue";
import { withCtx as r } from "vue";
import { createCommentVNode as l } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as c } from "vue";
import { ElMessage as D } from "element-plus";
import { ElTableColumn as R } from "element-plus";
import { ElImage as N } from "element-plus";
import { vLoading as S } from "element-plus";
import { c as O, u as B } from "../../../../modules/parallel-config-554d8028.js";
import { _ as H, x as U, fF as _, o as I, D as p, G as L, an as V, P as G } from "../../../../shared/runtime.js";
import K from "./module/header.vue.js";
import $ from "./module/form.vue.js";
import { _ as j } from "../../../../modules/SingleFileUploadBtn-17bec156.js";
import "./module/uploadBtn.vue.js";
const q = { class: "app-container" }, z = { class: "head-container" }, Q = { class: "board-box" }, X = { class: "error-slot" }, J = { key: 0 }, Y = { key: 1 }, Z = { __name: "index", setup(ee) {
  const y = { add: true, edit: false, del: false, download: false }, b = T(), { CRUD: k, crud: u, columns: s } = U({ title: "标准零件配置", sort: [], permission: { ..._ }, optShow: { ...y }, crudApi: { ...O }, hasPagination: true }, b), { maxHeight: C } = I({ wrapperBox: ".parallelConfig", paginate: true, extraHeight: 40 });
  function F() {
    D.success("上传成功"), u.toQuery();
  }
  return k.HOOK.handleRefresh = (x, h) => {
    var a;
    h.data.content = (a = h.data.content) == null ? void 0 : a.map((m) => (m.imgLoad = true, m));
  }, (x, h) => {
    const a = R, m = N, A = W("common-table"), M = E("permission"), P = S;
    return o(), g("div", q, [w("div", z, [n(t(K))]), v((o(), i(A, { ref_key: "tableRef", ref: b, class: "upload-table", data: t(u).data, "empty-text": t(u).emptyText, "max-height": t(C), "return-source-data": "", showEmptySymbol: false, stripe: false, style: { width: "100%" } }, { default: r(() => [n(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(s).visible("serialNumber") ? (o(), i(a, { key: "serialNumber", prop: "serialNumber", sortable: "custom", "show-overflow-tooltip": true, label: "编号", "min-width": "140px" })) : l("", true), t(s).visible("specification") ? (o(), i(a, { key: "specification", prop: "specification", sortable: "custom", "show-overflow-tooltip": true, label: "规格", "min-width": "120" }, { default: r((e) => [d(c(e.row.specification ? e.row.specification : "-"), 1)]), _: 1 })) : l("", true), t(s).visible("length") ? (o(), i(a, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: r((e) => [d(c(e.row.length ? e.row.length.toFixed(t(p).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })) : l("", true), t(s).visible("thick") ? (o(), i(a, { key: "thick", prop: "thick", sortable: "custom", "show-overflow-tooltip": true, label: `厚度
(mm)`, align: "left", "min-width": "85px" }, { default: r((e) => {
      var f;
      return [d(c(e.row.thick ? (f = Number(e.row.thick)) == null ? void 0 : f.toFixed(t(p).MES_ARTIFACT_T__MM) : "-"), 1)];
    }), _: 1 })) : l("", true), t(s).visible("material") ? (o(), i(a, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", align: "center", "min-width": "80px" }, { default: r((e) => [d(c(e.row.material ? e.row.material : "-"), 1)]), _: 1 })) : l("", true), t(s).visible("netWeight") ? (o(), i(a, { key: "netWeight", prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: r((e) => [d(c(e.row.netWeight ? e.row.netWeight.toFixed(t(p).COM_WT__KG) : "-"), 1)]), _: 1 })) : l("", true), t(s).visible("grossWeight") ? (o(), i(a, { key: "grossWeight", prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: r((e) => [d(c(e.row.grossWeight ? e.row.grossWeight.toFixed(t(p).COM_WT__KG) : "-"), 1)]), _: 1 })) : l("", true), t(s).visible("surfaceArea") ? (o(), i(a, { key: "surfaceArea", prop: "surfaceArea", sortable: "custom", label: `单面积
(㎡)`, align: "left", "min-width": "80px" }, { default: r((e) => [d(c(e.row.surfaceArea ? e.row.surfaceArea.toFixed(t(p).COM_AREA__M2) : "-"), 1)]), _: 1 })) : l("", true), t(s).visible("boolUpload") ? (o(), i(a, { key: 8, align: "center", prop: "boolUpload", label: "dxf上传" }, { default: r((e) => [v(n(t(j), { accept: ".dxf", data: { id: e.row.id, dataType: 2 }, tip: x.uploadType, size: "default", uploadFun: t(B), "btn-name": e.row.boolUpload ? "覆盖上传" : "上传", type: "primary", limit: 1, onSuccess: F }, null, 8, ["data", "tip", "uploadFun", "btn-name"]), [[M, t(_).import]])]), _: 1 })) : l("", true), t(s).visible("picturePath") ? (o(), i(a, { key: "picturePath", prop: "picturePath", label: "图片", align: "left", "min-width": "80px" }, { default: r((e) => [w("div", Q, [n(m, { src: e.row.picturePath, onError: (f) => e.row.imgLoad = false }, { error: r(() => [w("div", X, [e.row.picturePath ? (o(), g("span", J, "加载失败")) : (o(), g("span", Y, "未导入DXF"))])]), _: 2 }, 1032, ["src", "onError"])])]), _: 1 })) : l("", true), t(L)([...t(_).del, ...t(_).edit]) ? (o(), i(a, { key: 10, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: r((e) => [n(t(V), { data: e.row, "show-edit": false }, null, 8, ["data"])]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[P, t(u).loading]]), n(t(G)), n(t($))]);
  };
} }, ne = H(Z, [["__scopeId", "data-v-8ad447c8"]]);
export {
  ne as default
};
