import { resolveComponent as u } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as n } from "vue";
import { createVNode as t } from "vue";
import { withCtx as c } from "vue";
import { Fragment as r } from "vue";
import { renderList as h } from "vue";
import { createElementVNode as o } from "vue";
import { toDisplayString as _ } from "vue";
import { normalizeStyle as y } from "vue";
import { ElTableColumn as m } from "element-plus";
import { ElCard as b } from "element-plus";
import { _ as g } from "../../../../../../shared/runtime.js";
const D = { class: "upload-title" }, S = { __name: "technical-upload", props: { heightStyle: { type: String } }, setup(p) {
  const i = [{ title: "构件技术成果上传", table: [{ type: "构件图纸", uploadSpec: "文件导入支持PDF格式、DWG格式、ZIP压缩包格式（内容为PDF格式、DWG格式）", changeQuantity: 0, matchQuantity: 0 }, { type: "智造构件XML", uploadSpec: "文件导入支持XML格式、ZIP压缩包格式（内容为XML格式）", changeQuantity: 0, matchQuantity: 0 }] }, { title: "部件技术成果上传", table: [{ type: "部件图纸", uploadSpec: "文件导入支持PDF格式、DWG格式、ZIP压缩包格式（内容为PDF格式、DWG格式）", changeQuantity: 0, matchQuantity: 0 }, { type: "数控文件", uploadSpec: "文件导入仅支持NC1格式、ZIP压缩包格式（内容为NC1格式）", changeQuantity: 0, matchQuantity: 0 }] }, { title: "零件技术成果上传", table: [{ type: "零件图纸", uploadSpec: "文件导入支持PDF格式、DWG格式、ZIP压缩包格式（内容为PDF格式、DWG格式）", changeQuantity: 0, matchQuantity: 0 }, { type: "数控文件", uploadSpec: "文件导入仅支持DXF格式、ZIP压缩包格式（内容为DXF格式）", changeQuantity: 0, matchQuantity: 0 }] }];
  return (w, Q) => {
    const e = m, s = u("common-table"), d = b;
    return l(), n("div", { class: "technical-upload-content", style: y(p.heightStyle) }, [t(d, null, { default: c(() => [(l(), n(r, null, h(i, (a) => o("div", { class: "box-content", key: a.title }, [o("div", D, [o("span", null, "# " + _(a.title), 1)]), t(s, { data: a.table, style: { width: "100%" } }, { default: c(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { prop: "type", "show-overflow-tooltip": "", label: "类型", width: "100" }), t(e, { prop: "uploadSpec", "show-overflow-tooltip": "", label: "文件上传规范" }), t(e, { prop: "changeQuantity", "show-overflow-tooltip": "", label: "变更总数", width: "120" }), t(e, { prop: "matchQuantity", "show-overflow-tooltip": "", label: "文件匹配总数", width: "120" })]), _: 2 }, 1032, ["data"])])), 64))]), _: 1 })], 4);
  };
} }, v = g(S, [["__scopeId", "data-v-d9b68aa3"]]);
export {
  v as default
};
