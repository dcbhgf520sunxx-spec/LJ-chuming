import { ref as w } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as y } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as e } from "vue";
import { unref as t } from "vue";
import { createTextVNode as b } from "vue";
import { createCommentVNode as B } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as d } from "vue";
import { isRef as h } from "vue";
import { ElMessageBox as D } from "element-plus";
import { ElFormItem as N } from "element-plus";
import { ElForm as E } from "element-plus";
import { a as R } from "../../../../modules/enterprise-cloud-disk-7c8bf938.js";
import { u as F, G as I, W as L, p as v, R as z, S as M } from "../../../../shared/runtime.js";
import { c as O } from "../../../../modules/home-page-66a3681d.js";
const U = { __name: "detail-dialog", props: { modelValue: { type: Boolean, default: false }, detail: { type: Object, default: () => {
} }, detailId: { type: Number, default: void 0 } }, emits: ["update:modelValue", "del-success"], setup(o, { emit: C }) {
  const r = o, u = C, { visible: i, handleClose: n } = F({ emit: u, props: r }), V = w();
  async function k() {
    D.confirm("是否确认删除此企业网盘？", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      try {
        await R({ id: r.detailId }), n(), u("del-success");
      } catch (f) {
        console.log(f, "删除企业网盘失败");
      }
    });
  }
  return (f, a) => {
    const c = p("common-button"), s = N, g = E, x = p("common-dialog");
    return y(), _(x, { modelValue: t(i), "onUpdate:modelValue": a[0] || (a[0] = (T) => h(i) ? i.value = T : null), "before-close": t(n), title: "企业网盘详情", width: "650px", showClose: false }, { titleRight: e(() => [t(I)(t(O).editCloudDisk) ? (y(), _(c, { key: 0, type: "danger", size: "mini", onClick: k }, { default: e(() => a[1] || (a[1] = [b("删除")])), _: 1, __: [1] })) : B("", true), l(c, { onClick: t(n), size: "mini", plain: "" }, { default: e(() => a[2] || (a[2] = [b("取消")])), _: 1, __: [2] }, 8, ["onClick"])]), default: e(() => [l(g, { ref_key: "formRef", ref: V, "label-width": "90px" }, { default: e(() => [l(s, { label: "创建人" }, { default: e(() => [m("span", null, d(o.detail.createUserName), 1)]), _: 1 }), l(s, { label: "文件类型", prop: "sysHomeFileType" }, { default: e(() => [m("span", null, d(t(L).VL[o.detail.sysHomeFileType]), 1)]), _: 1 }), l(s, { label: "日期" }, { default: e(() => [m("span", null, d(t(v)(o.detail.informantDateTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 }), l(s, { label: "文件" }, { default: e(() => [l(z, { "show-download": "", "file-classify": t(M).NORMAL.V, files: o.detail.attachmentDTOList, uploadable: false, "empty-text": "暂未上传文件" }, null, 8, ["file-classify", "files"])]), _: 1 })]), _: 1 }, 512)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  U as default
};
